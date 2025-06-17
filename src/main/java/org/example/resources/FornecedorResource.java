package org.example.resources;

import org.example.DTO.FornecedorDTO;
import org.example.entities.Fornecedor;
import org.example.services.FornecedorService;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getAll() {
        List<Fornecedor> fornecedores = fornecedorService.getAll();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
        Fornecedor obj = fornecedorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> insert(@RequestBody FornecedorDTO fornecedorDTO) {
        Fornecedor createdFornecedor = fornecedorService.insert(fornecedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody FornecedorDTO fornecedorDto) {
        try {
            Fornecedor updatedFornecedor = fornecedorService.update(id, fornecedorDto);
            return ResponseEntity.ok(updatedFornecedor);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fornecedorService.deleteFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
