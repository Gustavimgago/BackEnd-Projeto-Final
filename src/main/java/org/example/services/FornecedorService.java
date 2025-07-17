package org.example.services;

import org.example.DTO.FornecedorDTO;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.entities.Fornecedor;
import org.example.repositories.ContatoRepository;
import org.example.repositories.EnderecoRepository;
import org.example.repositories.FornecedorRepository;

import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ContatoRepository contatoRepository;

    public List<Fornecedor> getAll() {
        return repository.findAll();
    }

    public Fornecedor findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Fornecedor insert(FornecedorDTO obj) {
        Fornecedor fornecedor = fromDTO(obj);
        return repository.save(fornecedor);
    }

    public Fornecedor update(Long id, FornecedorDTO objDto) {
        Fornecedor entity = findById(id);
        entity.setForNomeFantasia(objDto.getForNomeFantasia());
        entity.setForCnpj(objDto.getForCnpj());
        entity.setForRazaoSocial(objDto.getForRazaoSocial());

        // Atualiza ou adiciona endereços
        if (objDto.getEndRua() != null) {
            if (!entity.getEnderecos().isEmpty()) {
                Endereco endereco = entity.getEnderecos().get(0);
                endereco.setEndRua(objDto.getEndRua());
                endereco.setEndNumero(objDto.getEndNumero());
                endereco.setEndCidade(objDto.getEndCidade());
                endereco.setEndCep(objDto.getEndCep());
                endereco.setEndEstado(objDto.getEndEstado());
            } else {
                Endereco novoEndereco = new Endereco(null, entity, objDto.getEndRua(), objDto.getEndNumero(),
                        objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndEstado());
                entity.getEnderecos().add(novoEndereco);
            }
        }

        // Atualiza ou adiciona contatos
        if (objDto.getConEmail() != null) {
            if (!entity.getContatos().isEmpty()) {
                Contato contato = entity.getContatos().get(0);
                contato.setConCelular(objDto.getConCelular());
                contato.setConTelefoneComercial(objDto.getConTelefoneComercial());
                contato.setConEmail(objDto.getConEmail());
            } else {
                Contato novoContato = new Contato(null, entity, objDto.getConCelular(),
                        objDto.getConTelefoneComercial(), objDto.getConEmail());
                entity.getContatos().add(novoContato);
            }
        }

        return repository.save(entity); // Salva as alterações
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repository.deleteById(id);
    }

    public Fornecedor fromDTO(FornecedorDTO objDto) {
        Fornecedor fornecedor = new Fornecedor(null, objDto.getForNomeFantasia(), objDto.getForCnpj(), objDto.getForRazaoSocial());
        Endereco endereco = new Endereco(null, fornecedor, objDto.getEndRua(), objDto.getEndNumero(),
                objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndEstado());
        Contato contato = new Contato(null, fornecedor, objDto.getConCelular(), objDto.getConTelefoneComercial(),
                objDto.getConEmail());

        fornecedor.getEnderecos().add(endereco);
        fornecedor.getContatos().add(contato);

        return fornecedor;
    }
}

