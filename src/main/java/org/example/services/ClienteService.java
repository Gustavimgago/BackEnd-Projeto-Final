package org.example.services;

import org.example.DTO.ClienteDTO;
import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.entities.FormaPagamento;
import org.example.repositories.ClienteRepository;
import org.example.repositories.ContatoRepository;
import org.example.repositories.EnderecoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    public  List<Cliente> getAll(){
        return repository.findAll();
    }

    public Cliente findById(Long id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new
                ResourceNotFoundException(id));
    }

    public Cliente insert(ClienteDTO obj){
        Cliente cliente = fromDTO(obj);
        try{
            cliente.setCliId(null);
            cliente = repository.save(cliente);
            enderecoRepository.saveAll(cliente.getEnderecos());
            contatoRepository.saveAll(cliente.getContatos());
            return cliente;
        }catch (DataIntegrityViolationException e){
            throw  new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Cliente update(Long id, ClienteDTO objDto) {
        try {
            Cliente entity = findById(id);

            // Atualiza os dados do cliente
            entity.setCliNome(objDto.getCliNome());
            entity.setCliCpf(objDto.getCliCpf());

            // Atualiza o endereço do cliente
            if (entity.getEnderecos() != null && !entity.getEnderecos().isEmpty()) {
                Endereco endereco = entity.getEnderecos().get(0);
                endereco.setEndRua(objDto.getEndRua());
                endereco.setEndNumero(objDto.getEndNumero());
                endereco.setEndCidade(objDto.getEndCidade());
                endereco.setEndCep(objDto.getEndCep());
                endereco.setEndEstado(objDto.getEndEstado());
            } else {
                // Se não houver endereços, você pode optar por adicionar um novo
                Endereco novoEndereco = new Endereco();
                novoEndereco.setEndRua(objDto.getEndRua());
                novoEndereco.setEndNumero(objDto.getEndNumero());
                novoEndereco.setEndCidade(objDto.getEndCidade());
                novoEndereco.setEndCep(objDto.getEndCep());
                novoEndereco.setEndEstado(objDto.getEndEstado());
                entity.getEnderecos().add(novoEndereco);
            }

            // Atualiza o contato
            if (entity.getContatos() != null && !entity.getContatos().isEmpty()) {
                Contato contato = entity.getContatos().get(0);
                contato.setConCelular(objDto.getConCelular());
                contato.setConTelefoneComercial(objDto.getConTelefoneComercial());
                contato.setConEmail(objDto.getConEmail());
            } else {
                // Se não houver contatos, você pode optar por adicionar um novo
                Contato novoContato = new Contato();
                novoContato.setConCelular(objDto.getConCelular());
                novoContato.setConTelefoneComercial(objDto.getConTelefoneComercial());
                novoContato.setConEmail(objDto.getConEmail());
                entity.getContatos().add(novoContato);
            }

            // Salva as alterações
            repository.save(entity);
            return entity;
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Cliente não encontrado com ID: " + id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage());
        }
    }


    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        Cliente cliente = new Cliente(null, objDto.getCliNome(), objDto.getCliCpf());

        Endereco endereco = new Endereco(null, cliente, objDto.getEndRua(), objDto.getEndNumero(),
                objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndEstado());

        Contato contato = new Contato(null, cliente, objDto.getConCelular(), objDto.getConTelefoneComercial(),
                objDto.getConEmail());

        cliente.getEnderecos().add(endereco);
        cliente.getContatos().add(contato);

        return cliente;
    }

    public ClienteDTO toNewDTO(Cliente obj) {
        ClienteDTO dto = new ClienteDTO();

// Mapeie os atributos comuns entre Cliente e ClienteNewDTO
        dto.setCliId(obj.getCliId());
        dto.setCliNome(obj.getCliNome());
        dto.setCliCpf(obj.getCliCpf());

// Atributos específicos de Endereco
        Endereco endereco = obj.getEnderecos().get(0);
        dto.setEndRua(endereco.getEndRua());
        dto.setEndNumero(endereco.getEndNumero());
        dto.setEndCidade(endereco.getEndCidade());
        dto.setEndCep(endereco.getEndCep());
        dto.setEndEstado(endereco.getEndEstado());

// Atributos específicos de Contato
        Contato contato = obj.getContatos().get(0);
        dto.setConCelular(contato.getConCelular());
        dto.setConTelefoneComercial(contato.getConTelefoneComercial());
        dto.setConEmail(contato.getConEmail());

        return dto;
    }
}