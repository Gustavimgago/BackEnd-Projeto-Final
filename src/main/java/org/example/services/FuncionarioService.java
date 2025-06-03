package org.example.services;

import org.example.entities.Cliente;
import org.example.entities.Funcionario;
import org.example.repositories.FuncionarioRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> getAll() { return repository.findAll(); }

    public Funcionario findById(long id){
        Optional<Funcionario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Funcionario insert(Funcionario funcionario) { return repository.save(funcionario); }

    public boolean update(Long id, Funcionario funcionario){
        Optional<Funcionario> optionalFuncionario = repository.findById(id);
        if (optionalFuncionario.isPresent()) {
            Funcionario funcionario1 = optionalFuncionario.get();
            funcionario1.setFunciNome(funcionario.getFunciNome());
            funcionario1.setFunciCargo(funcionario.getFunciCargo());
            funcionario1.setFunciEmail(funcionario.getFunciEmail());
            funcionario1.setFunciTelefone(funcionario.getFunciTelefone());
            repository.save(funcionario1);
            return true;
        }
        return false;
    }
    public void delete(Long id) { repository.deleteById(id); }
}
