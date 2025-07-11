package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class ProdutoVenda { /*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRV_ID")
    private Long prvId;

    @NotNull(message = "Quantidade é obrigatória")
    @Column(name = "PRV_QUANTIDADE", nullable = false)
    private Integer prvQuantidade;

    @NotNull(message = "Preço unitário é obrigatório")
    @Column(name = "PRV_PRECO_UNITARIO", nullable = false)
    private Double prvPrecoUnitario;

    @ManyToOne
    @JoinColumn(name = "VEN_ID", nullable = false)
    private Vendas vendas; // FK para Venda

    @ManyToOne
    @JoinColumn(name = "PROD_ID", nullable = false)
    private Produto produto; // FK para Produto

    // Construtores
    public ProdutoVenda() {
    }

    public ProdutoVenda(Long prvId, Integer prvQuantidade, Double prvPrecoUnitario) {
        this.prvId = prvId;
        this.prvQuantidade = prvQuantidade;
        this.prvPrecoUnitario = prvPrecoUnitario;
    }

    // Getters e Setters
    public Long getPrvId() {
        return prvId;
    }

    public void setPrvId(Long prvId) {
        this.prvId = prvId;
    }

    public Integer getPrvQuantidade() {
        return prvQuantidade;
    }

    public void setPrvQuantidade(Integer prvQuantidade) {
        this.prvQuantidade = prvQuantidade;
    }

    public Double getPrvPrecoUnitario() {
        return prvPrecoUnitario;
    }

    public void setPrvPrecoUnitario(Double prvPrecoUnitario) {
        this.prvPrecoUnitario = prvPrecoUnitario;
    }

    public Vendas getVendas() {
        return vendas;
    }

    public void setVenda(Vendas vendas) {
        this.vendas = vendas;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }*/
}

