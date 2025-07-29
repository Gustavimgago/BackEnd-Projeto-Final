package org.example.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VND_ID")
    private Long vndId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "CLI_ID", nullable = false)
    private Cliente cliente;
    @ManyToOne(optional = false)
    @JoinColumn(name = "FUN_ID", nullable = false)
    private Funcionario funcionario;
    @ManyToOne(optional = false)
    @JoinColumn(name = "FPG_ID", nullable = false)
    private FormaPagamento formaPagamento;
    @Column(name = "VND_DATA", nullable = false)
    private LocalDateTime vndData = LocalDateTime.now(); // Data atual automática
    @Column(name = "VND_TOTAL", nullable = false)
    private Double vndTotal;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens;

    public Venda() {
    }

    public Venda(Long vndId, LocalDateTime vndData, Double vndTotal) {
        this.vndId = vndId;
        this.vndData = vndData;
        this.vndTotal = vndTotal;

    }

    public Long getVndId() {
        return vndId;
    }

    public void setVndId(Long vndId) {
        this.vndId = vndId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public LocalDateTime getVndData() {
        return vndData;
    }

    public void setVndData(LocalDateTime vndData) {
        this.vndData = vndData;
    }

    public Double getVndTotal() {
        return vndTotal;
    }

    public void setVndTotal(Double vndTotal) {
        this.vndTotal = vndTotal;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}
