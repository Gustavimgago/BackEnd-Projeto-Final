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

    public List<Cliente> getAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Cliente insert(ClienteDTO obj) {
        Cliente cliente = fromDTO(obj);
        return repository.save(cliente); // Salva o cliente e suas associações
    }

    public Cliente update(Long id, ClienteDTO objDto) {
        Cliente entity = findById(id);
        entity.setCliNome(objDto.getCliNome());
        entity.setCliCpf(objDto.getCliCpf());

        // Atualiza o primeiro endereço, se existir
        if (!entity.getEnderecos().isEmpty()) {
            Endereco endereco = entity.getEnderecos().get(0);
            endereco.setEndRua(objDto.getEndRua());
            endereco.setEndNumero(objDto.getEndNumero());
            endereco.setEndCidade(objDto.getEndCidade());
            endereco.setEndCep(objDto.getEndCep());
            endereco.setEndEstado(objDto.getEndEstado());
        } else {
            // Adiciona um novo endereço se não houver
            Endereco novoEndereco = new Endereco(null, entity, objDto.getEndRua(), objDto.getEndNumero(),
                    objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndEstado());
            entity.getEnderecos().add(novoEndereco);
        }

        // Atualiza o primeiro contato, se existir
        if (!entity.getContatos().isEmpty()) {
            Contato contato = entity.getContatos().get(0);
            contato.setConCelular(objDto.getConCelular());
            contato.setConTelefoneComercial(objDto.getConTelefoneComercial());
            contato.setConEmail(objDto.getConEmail());
        } else {
            // Adiciona um novo contato se não houver
            Contato novoContato = new Contato(null, entity, objDto.getConCelular(),
                    objDto.getConTelefoneComercial(), objDto.getConEmail());
            entity.getContatos().add(novoContato);
        }

        return repository.save(entity); // Salva as alterações
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        Cliente cliente = new Cliente(null, objDto.getCliNome(), objDto.getCliCpf());
        Endereco endereco = new Endereco(null, cliente, objDto.getEndRua(), objDto.getEndNumero(),
                objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndEstado());
        Contato contato = new Contato(null, cliente, objDto.getConCelular(),
                objDto.getConTelefoneComercial(), objDto.getConEmail());
        cliente.getEnderecos().add(endereco);
        cliente.getContatos().add(contato);
        return cliente;
    }
}
