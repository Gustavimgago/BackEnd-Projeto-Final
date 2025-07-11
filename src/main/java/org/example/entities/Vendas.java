package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Vendas{ /*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VEN_ID")
    private Long venId;

    @NotNull(message = "Data da venda é obrigatória")
    @Column(name = "VEN_DATA", nullable = false)
    private Date venData;

    @NotNull(message = "Total da venda é obrigatório")
    @Column(name = "VEN_TOTAL", nullable = false)
    private Double venTotal;

    @NotBlank(message = "Método de pagamento é obrigatório")
    @Column(name = "VEN_METODO_PAGAMENTO", nullable = false, length = 50)
    private String venMetodoPagamento;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente cliente; // FK para a entidade Cliente

    @OneToMany(mappedBy = "PRODUTOVENDA", cascade = CascadeType.ALL)
    private List<ProdutoVenda> produtosVenda = new ArrayList<>(); // Lista de produtos vendidos

    public Vendas() {
    }

    public Vendas(Long venId, Date venData, Double venTotal, String venMetodoPagamento) {
        this.venId = venId;
        this.venData = venData;
        this.venTotal = venTotal;
        this.venMetodoPagamento = venMetodoPagamento;
    }

    public Long getVenId() {
        return venId;
    }

    public void setVenId(Long venId) {
        this.venId = venId;
    }

    public Date getVenData() {
        return venData;
    }

    public void setVenData(Date venData) {
        this.venData = venData;
    }

    public Double getVenTotal() {
        return venTotal;
    }

    public void setVenTotal(Double venTotal) {
        this.venTotal = venTotal;
    }

    public String getVenMetodoPagamento() {
        return venMetodoPagamento;
    }

    public void setVenMetodoPagamento(String venMetodoPagamento) {
        this.venMetodoPagamento = venMetodoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoVenda> getProdutosVenda() {
        return produtosVenda;
    }

    public void setProdutosVenda(List<ProdutoVenda> produtosVenda) {
        this.produtosVenda = produtosVenda;
    } */
}

