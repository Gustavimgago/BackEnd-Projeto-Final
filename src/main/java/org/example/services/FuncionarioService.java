package org.example.services;

import org.example.DTO.FuncionarioDTO;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.entities.Funcionario;
import org.example.repositories.FuncionarioRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> getAll() {
        return repository.findAll();
    }

    public Funcionario findById(long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Funcionario insert(FuncionarioDTO obj) {
        Funcionario funcionario = fromDTO(obj);
        return repository.save(funcionario);
    }

    public Funcionario update(Long id, FuncionarioDTO objDto) {
        Funcionario entity = findById(id);

        // Validação dos dados do DTO
        if (objDto.getFunciNome() == null || objDto.getFunciNome().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário não pode ser vazio");
        }

        entity.setFunciNome(objDto.getFunciNome());
        entity.setFunciCargo(objDto.getFunciCargo());
        entity.setFunciCpf(objDto.getFunciCpf());

        // Atualiza ou adiciona endereço
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

        // Atualiza ou adiciona contato
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

        return repository.save(entity);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Funcionario fromDTO(FuncionarioDTO objDto) {
        Funcionario funcionario = new Funcionario(null, objDto.getFunciNome(), objDto.getFunciCargo(), objDto.getFunciCpf());
        Endereco endereco = new Endereco(null, funcionario, objDto.getEndRua(), objDto.getEndNumero(),
                objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndEstado());
        Contato contato = new Contato(null, funcionario, objDto.getConCelular(),
                objDto.getConTelefoneComercial(), objDto.getConEmail());
        funcionario.getEnderecos().add(endereco);
        funcionario.getContatos().add(contato);
        return funcionario;
    }
}
