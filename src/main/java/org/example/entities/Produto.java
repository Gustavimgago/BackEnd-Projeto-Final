package org.example.entities;

import org.example.repositories.FornecedorRepository;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @ManyToOne
    @JoinColumn(name = "FOR_ID", nullable = false)
    private Fornecedor fornecedor;


    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 255, message = "Nome deve ter no máximo 255 caracteres")
    @Column(name = "PRO_NOME")
    private String proNome;

    @NotNull(message = "Preço de Custo é obrigatório")
    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2, nullable = false)
    private Double proPrecoCusto;

    @NotNull(message = "Preço de Venda é obrigatório")
    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2, nullable = false)
    private Double proPrecoVenda;

    @Size(max = 500, message = "Descrição deve ter no máximo 500 caracteres")
    @Column(name = "PRO_DESCRICAO")
    private String proDescricao;

    @NotNull(message = "Quantidade em Estoque é obrigatória")
    @Column(name = "PRO_QUANTIDADESTOCK", nullable = false)
    private int proQuantidadeStock;

    @Size(max = 50, message = "Status deve ter no máximo 50 caracteres")
    @Column(name = "PRO_STATUS")
    private String proStatus;

    @Size(max = 100, message = "Categoria deve ter no máximo 100 caracteres")
    @Column(name = "PRO_CATEGORIA")
    private String proCategoria;

    @Size(max = 50, message = "Código de Barras deve ter no máximo 50 caracteres")
    @Column(name = "PRO_CODIGOBARRAS")
    private String proCodigoBarras;

    @Size(max = 100, message = "Marca deve ter no máximo 100 caracteres")
    @Column(name = "PRO_MARCA")
    private String proMarca;

    @Column(name = "PRO_DATACADASTRO")
    private LocalDateTime proDataCadastro;

    @Column(name = "PRO_DATAATUALIZACAO")
    private LocalDateTime proDataAtualizacao;

    public Produto() {
    }

    public Produto(Long proId, Fornecedor fornecedor, String proNome, Double proPrecoCusto, Double proPrecoVenda, String proDescricao, int proQuantidadeStock, String proStatus, String proCategoria, String proCodigoBarras, String proMarca, LocalDateTime proDataCadastro, LocalDateTime proDataAtualizacao) {
        this.proId = proId;
        this.fornecedor = fornecedor;
        this.proNome = proNome;
        this.proPrecoCusto = proPrecoCusto;
        this.proPrecoVenda = proPrecoVenda;
        this.proDescricao = proDescricao;
        this.proQuantidadeStock = proQuantidadeStock;
        this.proStatus = proStatus;
        this.proCategoria = proCategoria;
        this.proCodigoBarras = proCodigoBarras;
        this.proMarca = proMarca;
        this.proDataCadastro = proDataCadastro;
        this.proDataAtualizacao = proDataAtualizacao;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public Double getProPrecoCusto() {
        return proPrecoCusto;
    }

    public void setProPrecoCusto(Double proPrecoCusto) {
        this.proPrecoCusto = proPrecoCusto;
    }

    public Double getProPrecoVenda() {
        return proPrecoVenda;
    }

    public void setProPrecoVenda(Double proPrecoVenda) {
        this.proPrecoVenda = proPrecoVenda;
    }

    public String getProDescricao() {
        return proDescricao;
    }

    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    public int getProQuantidadeStock() {
        return proQuantidadeStock;
    }

    public void setProQuantidadeStock(int proQuantidadeStock) {
        this.proQuantidadeStock = proQuantidadeStock;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public String getProCategoria() {
        return proCategoria;
    }

    public void setProCategoria(String proCategoria) {
        this.proCategoria = proCategoria;
    }

    public String getProCodigoBarras() {
        return proCodigoBarras;
    }

    public void setProCodigoBarras(String proCodigoBarras) {
        this.proCodigoBarras = proCodigoBarras;
    }

    public String getProMarca() {
        return proMarca;
    }

    public void setProMarca(String proMarca) {
        this.proMarca = proMarca;
    }

    public LocalDateTime getProDataCadastro() {
        return proDataCadastro;
    }

    public void setProDataCadastro(LocalDateTime proDataCadastro) {
        this.proDataCadastro = proDataCadastro;
    }

    public LocalDateTime getProDataAtualizacao() {
        return proDataAtualizacao;
    }

    public void setProDataAtualizacao(LocalDateTime proDataAtualizacao) {
        this.proDataAtualizacao = proDataAtualizacao;
    }
}