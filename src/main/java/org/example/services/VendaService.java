package org.example.services;

import org.example.entities.*;
import org.example.repositories.*;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // Cria uma venda com cálculo automático de totais
    @Transactional
    public Venda insert(Venda venda) {
        // Calcula subtotal e valida estoque para cada item
        venda.getItens().forEach(item -> {
            Produto produto = produtoRepository.findById(item.getProduto().getProId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            if (produto.getProQuantidadeStock() < item.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getProNome());
            }

            // Atualiza estoque
            produto.setProQuantidadeStock(produto.getProQuantidadeStock() - item.getQuantidade());
            produtoRepository.save(produto);

            // Calcula valores
            item.setPrecoUnitario(produto.getProPrecoVenda());
            item.setSubTotal(item.getQuantidade() * produto.getProPrecoVenda());
        });

        // Calcula total da venda
        Double total = venda.getItens().stream()
                .mapToDouble(ItemVenda::getSubTotal)
                .sum();
        venda.setVndTotal(total);

        return repository.save(venda);
    }

    // Lista todas as vendas
    public List<Venda> getAll() {
        return repository.findAll();
    }

    // Busca venda por ID
    public Venda findById(Long id) {
        Optional<Venda> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Deleta uma venda (com tratamento de estoque)
    @Transactional
    public void delete(Long id) {
        Venda venda = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        // Devolve os produtos ao estoque
        venda.getItens().forEach(item -> {
            Produto produto = produtoRepository.findById(item.getProduto().getProId()).get();
            produto.setProQuantidadeStock(produto.getProQuantidadeStock() + item.getQuantidade());
            produtoRepository.save(produto);
        });

        repository.deleteById(id);
    }
}
