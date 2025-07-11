package org.example.services;

import org.example.entities.ProdutoVenda;
import org.example.entities.Vendas;
import org.example.repositories.ProdutoVendaRepository;
import org.example.repositories.VendasRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ProdutoVendaService {/*

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;

    @Autowired
    private VendasRepository vendasRepository;

    public List<ProdutoVenda> findAll() {
        return produtoVendaRepository.findAll();
    }

    public ProdutoVenda findById(Long id) {
        return produtoVendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ProdutoVenda insert(ProdutoVenda produtoVenda, Long vendaId) {
        // Verifica se a venda existe
        Vendas vendas = vendasRepository.findById(vendaId)
                .orElseThrow(() -> new ResourceNotFoundException(vendaId));
        // Associa o produto à venda
        produtoVenda.setVenda(vendas);
        return produtoVendaRepository.save(produtoVenda);
    }

    public void delete(Long id) {
        produtoVendaRepository.deleteById(id);
    }*/
}

