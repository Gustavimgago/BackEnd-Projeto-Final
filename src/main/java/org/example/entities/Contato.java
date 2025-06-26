package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_ID")
    private Long conId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CON_CLI_ID")
    private Cliente conCliente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CON_FOR_ID")
    private Fornecedor conFornecedor;

    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Número de celular inválido")
    @Column(name = "CON_CELULAR", length = 20)
    private String conCelular;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Número de telefone comercial inválido")
    @Column(name = "CON_TELEFONE_COMERCIAL", length = 20)
    private String conTelefoneComercial;

    @Email (message = "Email inválido")
    @Column(length = 55, name = "CON_EMAIL")
    private String conEmail;

    public Contato() {
    }

    public Contato(Long conId, Cliente cliente ,String conCelular, String conTelefoneComercial, String conEmail) {
        this.conId = conId;
        this.conCliente = cliente;
        this.conCelular = conCelular;
        this.conTelefoneComercial = conTelefoneComercial;
        this.conEmail = conEmail;
    }

    public Contato(Long conId, Fornecedor fornecedor ,String conCelular, String conTelefoneComercial, String conEmail) {
        this.conId = conId;
        this.conFornecedor = fornecedor;
        this.conCelular = conCelular;
        this.conTelefoneComercial = conTelefoneComercial;
        this.conEmail = conEmail;
    }

    public Long getConId() {
        return conId;
    }

    public void setConId(Long conId) {
        this.conId = conId;
    }

    public Cliente getConCliente() {
        return conCliente;
    }

    public void setConCliente(Cliente conCliente) {
        this.conCliente = conCliente;
    }

    public Fornecedor getContFornecedor() {
        return conFornecedor;
    }

    public void setContFornecedor(Fornecedor contFornecedor) {
        this.conFornecedor = contFornecedor;
    }

    public String getConCelular() {
        return conCelular;
    }

    public void setConCelular(String conCelular) {
        this.conCelular = conCelular;
    }

    public String getConTelefoneComercial() {
        return conTelefoneComercial;
    }

    public void setConTelefoneComercial(String conTelefoneComercial) {
        this.conTelefoneComercial = conTelefoneComercial;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }
}
