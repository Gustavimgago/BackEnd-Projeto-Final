package org.example.services;

import org.example.entities.Fornecedor;
import org.example.entities.Produto;
import org.example.repositories.FornecedorRepository;
import org.example.repositories.ProdutoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Produto> getAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Produto insert(Produto produto) {
        if (produto.getFornecedor() == null || produto.getFornecedor().getForId() == null) {
            throw new IllegalArgumentException("Fornecedor não pode ser nulo");
        }
        Fornecedor fornecedor = fornecedorRepository.findById(produto.getFornecedor().getForId())
                .orElseThrow(() -> new ResourceNotFoundException(produto.getFornecedor().getForId()));

        produto.setFornecedor(fornecedor); // Atribuindo o fornecedor encontrado
        return repository.save(produto);
    }

    public boolean update(Long id, Produto produto) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produtoSistema = optionalProduto.get();
            produtoSistema.setProNome(produto.getProNome());
            produtoSistema.setProPrecoCusto(produto.getProPrecoCusto());
            produtoSistema.setProPrecoVenda(produto.getProPrecoVenda());
            produtoSistema.setProDescricao(produto.getProDescricao());
            produtoSistema.setProQuantidadeStock(produto.getProQuantidadeStock());
            produtoSistema.setProStatus(produto.getProStatus());

            Fornecedor fornecedor = fornecedorRepository.findById(produto.getFornecedor().getForId())
                    .orElseThrow(() -> new ResourceNotFoundException(produto.getFornecedor().getForId()));
            produtoSistema.setFornecedor(fornecedor);

            repository.save(produtoSistema);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
