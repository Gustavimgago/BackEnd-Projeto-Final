package org.example.services;

import org.example.DTO.ClienteDTO;
import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.repositories.ClienteRepository;
import org.example.repositories.ContatoRepository;
import org.example.repositories.EnderecoRepository;

import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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

    public List<Cliente> getAll(){
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Cliente insert(Cliente obj) {
        try {
            obj.setCliId(null);
            obj = repository.save(obj);
            enderecoRepository.saveAll(obj.getEnderecos());
            return obj;
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }

    }

    public Cliente update(Long id, ClienteDTO objDto) {
        try {
            Cliente entity = findById(id);
            entity.setCliNome(objDto.getCliNome());
            entity.setCliCpf(objDto.getCliCpf());

            Endereco endereco = entity.getEnderecos().get(0);

            endereco.setEndRua(objDto.getEndRua());
            endereco.setEndNumero(objDto.getEndNumero());
            endereco.setEndCidade(objDto.getEndCidade());
            endereco.setEndCep(objDto.getEndCep());
            endereco.setEndEstado(objDto.getEndEstado());

            Contato contato = entity.getContatos().get(0);

            contato.setConCelular(objDto.getConCelular());
            contato.setConTelefoneComercial(objDto.getConTelefoneComercial());
            contato.setConEmail(objDto.getConEmail());

            repository.save(entity);

            return entity;

        }catch (DataIntegrityViolationException e){
                throw new ValueBigForAtributeException(e.getMessage()
                );
        }

    }

    public void deleteCliente(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        Cliente fornec = new Cliente(null, objDto.getCliNome(), objDto.getCliCpf());
        Endereco ender = new Endereco(null, objDto.getEndRua(), objDto.getEndNumero(), objDto.getEndCidade(),
                objDto.getEndCep(), objDto.getEndEstado());
        ender.setEndCliente(fornec);
        Contato contato = new Contato(null, objDto.getConCelular(), objDto.getConTelefoneComercial(), objDto.getConEmail());
        contato.setConCliente(fornec);
        fornec.getEnderecos().add(ender);
        fornec.getContatos().add(contato);
        return fornec;
    }

    public ClienteDTO toNewDTO(Cliente obj) {
        ClienteDTO dto = new ClienteDTO();

// Mapeie os atributos comuns entre Cliente e ClienteNewDTO
        obj.setCliId(dto.getCliId());
        obj.setCliNome(dto.getCliNome());
        obj.setCliCpf(dto.getCliCpf());

// Atributos específicos de Endereco
        Endereco endereco = obj.getEnderecos().get(0);
        endereco.setEndRua(dto.getEndRua());
        endereco.setEndNumero(dto.getEndNumero());
        endereco.setEndCidade(dto.getEndCidade());
        endereco.setEndCep(dto.getEndCep());
        endereco.setEndEstado(dto.getEndEstado());

// Atributos específicos de Contato
        Contato contato = obj.getContatos().get(0);
        contato.setConCelular(dto.getConCelular());
        contato.setConTelefoneComercial(dto.getConTelefoneComercial());
        contato.setConEmail(dto.getConEmail());

        return dto;

    }

}
