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
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Fornecedor findById(Long id){
        Optional<Fornecedor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Fornecedor insert(Fornecedor obj) {
        try {
            obj.setForId(null);
            obj = repository.save(obj);
            enderecoRepository.saveAll(obj.getEnderecos());
            return obj;
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }

    }

    public Fornecedor update(Long id, FornecedorDTO objDto) {
        try {
            Fornecedor entity = findById(id);
            entity.setForCnpj(objDto.getForCnpj());
            entity.setForNomeFantasia(objDto.getForNomeFantasia());
            entity.setForRazaoSocial(objDto.getForRazaoSocial());

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

    public void deleteFornecedor(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public Fornecedor fromDTO(FornecedorDTO objDto) {
        Fornecedor fornece = new Fornecedor(null, objDto.getForCnpj(), objDto.getForNomeFantasia(), objDto.getForRazaoSocial());
        Endereco ender = new Endereco(null, objDto.getEndRua(), objDto.getEndNumero(), objDto.getEndCidade(),
                objDto.getEndCep(), objDto.getEndEstado());
        ender.setEndFornecedor(fornece); // Associando corretamente ao Fornecedor
        Contato contato = new Contato(null, objDto.getConCelular(), objDto.getConTelefoneComercial(), objDto.getConEmail());
        contato.setContFornecedor(fornece); // Certifique-se de que este método existe
        fornece.getEnderecos().add(ender);
        fornece.getContatos().add(contato);
        return fornece;
    }

    public FornecedorDTO toNewDTO(Fornecedor obj){
        FornecedorDTO dto = new FornecedorDTO();

        obj.setForId(dto.getForId());
        obj.setForCnpj(dto.getForCnpj());
        obj.setForNomeFantasia(dto.getForNomeFantasia());
        obj.setForRazaoSocial(dto.getForRazaoSocial());

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