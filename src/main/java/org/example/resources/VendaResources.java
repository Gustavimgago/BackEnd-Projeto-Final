package org.example.resources;

import org.example.entities.ProdutoVenda;
import org.example.entities.Vendas;
import org.example.services.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/vendas")

public class VendasResources {/*

    @Autowired
    private VendasService vendasService;

    // Listar todas as vendas
    @GetMapping
    public ResponseEntity<List<Vendas>> findAll() {
        List<Vendas> vendas = vendasService.findAll();
        return ResponseEntity.ok(vendas);
    }

    // Buscar venda por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendas> findById(@PathVariable Long id) {
        Vendas venda = vendasService.findById(id);
        return ResponseEntity.ok(venda);
    }

    // Criar nova venda
    @PostMapping
    public ResponseEntity<Vendas> insert(@RequestBody Vendas vendas) {
        Vendas novaVenda = vendasService.insert(vendas);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
    }

    // Atualizar venda
    @PutMapping("/{id}")
    public ResponseEntity<Vendas> update(@PathVariable Long id, @RequestBody Vendas vendas) {
        Vendas vendaAtualizada = vendasService.update(id, vendas);
        return ResponseEntity.ok(vendaAtualizada);
    }

    // Deletar venda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vendasService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Listar produtos de uma venda específica
    @GetMapping("/{id}/produtos")
    public ResponseEntity<List<ProdutoVenda>> getProdutosDaVenda(@PathVariable Long id) {
        List<ProdutoVenda> produtos = vendasService.getProdutosDaVenda(id);
        return ResponseEntity.ok(produtos);
    }*/
}
