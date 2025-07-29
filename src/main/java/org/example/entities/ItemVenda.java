package org.example.entities;

import javax.persistence.*;

@Entity
@Table(name = "TB_ITEM_VENDA")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IVD_ID")
    private Long ivdId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PRO_ID", nullable = false)
    private Produto produto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "VND_ID", nullable = false)
    private Venda venda;

    @Column(name = "IVD_QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name = "IVD_PRECO_UNITARIO", nullable = false)
    private Double precoUnitario;

    @Column(name = "IVD_SUBTOTAL", nullable = false)
    private Double subTotal;

    public ItemVenda() {
    }

    public ItemVenda(Long ivdId, Integer quantidade, Double precoUnitario, Double subTotal) {
        this.ivdId = ivdId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.subTotal = subTotal;
    }

    public Long getIvdId() {
        return ivdId;
    }

    public void setIvdId(Long ivdId) {
        this.ivdId = ivdId;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
