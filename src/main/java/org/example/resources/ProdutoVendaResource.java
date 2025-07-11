package org.example.resources;

import org.example.entities.ProdutoVenda;
import org.example.services.ProdutoVendaService;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.entities.Vendas;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/produtos-venda")
public class ProdutoVendaResource {/*

    @Autowired
    private ProdutoVendaService produtoVendaService;

    // Listar todos os produtos vendidos (opcional, se necessário)
    @GetMapping
    public ResponseEntity<List<ProdutoVenda>> findAll() {
        List<ProdutoVenda> produtos = produtoVendaService.findAll();
        return ResponseEntity.ok(produtos);
    }

    // Buscar produto-venda por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoVenda> findById(@PathVariable Long id) {
        ProdutoVenda produtoVenda = produtoVendaService.findById(id);
        return ResponseEntity.ok(produtoVenda);
    }

    // Adicionar um produto a uma venda existente
    @PostMapping
    public ResponseEntity<ProdutoVenda> insert(
            @RequestBody ProdutoVenda produtoVenda,
            @RequestParam Long vendaId
    ) {
        ProdutoVenda novoProdutoVenda = produtoVendaService.insert(produtoVenda, vendaId);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProdutoVenda);
    }

    // Remover produto de uma venda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoVendaService.delete(id);
        return ResponseEntity.noContent().build();
    }*/
}
