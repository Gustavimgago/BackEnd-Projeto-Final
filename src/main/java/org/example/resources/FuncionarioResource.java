package org.example.resources;

import org.example.DTO.FuncionarioDTO;
import org.example.entities.Cliente;
import org.example.entities.Funcionario;
import org.example.services.FuncionarioService;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAll(){
        List<Funcionario> funcionarios = funcionarioService.getAll();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario>findById(@PathVariable Long id) {
        Funcionario obj = funcionarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Funcionario> insert(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario createdFuncionario = funcionarioService.insert(funcionarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFuncionario);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<?> update(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO){
        try {
            Funcionario updatedFuncionario = funcionarioService.update(id, funcionarioDTO);
            return ResponseEntity.ok(updatedFuncionario);
        }catch (ResourceNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
