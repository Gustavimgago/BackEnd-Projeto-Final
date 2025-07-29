package org.example.entities;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FUNCI_ID")
    private Long funciId;

    @OneToMany(mappedBy = "endFuncionario", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "conFuncionario", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome do funcionario deve ter no máximo 100 caracteres")
    @Column(name = "FUNCI_NOME", nullable = false, length = 100)
    private String funciNome;

    @NotBlank(message = "O cargo é obrigatório")
    @Size(max = 100, message = "Cargo deve ter no máximo 100 caracteres")
    @Column(name = "FUNCI_CARGO", nullable = false, length = 100)
    private String funciCargo;

    @NotBlank(message = "CPF é obrigatório")
    @CPF(message = "CPF inválido")
    @Column(name = "FUNCI_CPF", nullable = false, unique = true, length = 15)
    private String funciCpf;


    public Funcionario() {
    }

    public Funcionario(Long funciId, String funciNome, String funciCargo, String funciCpf) {
        this.funciId = funciId;
        this.funciNome = funciNome;
        this.funciCargo = funciCargo;
        this.funciCpf = funciCpf;
    }

    public Long getFunciId() {
        return funciId;
    }

    public void setFunciId(Long funciId) {
        this.funciId = funciId;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public String getFunciNome() {
        return funciNome;
    }

    public void setFunciNome(String funciNome) {
        this.funciNome = funciNome;
    }

    public String getFunciCargo() {
        return funciCargo;
    }

    public void setFunciCargo(String funciCargo) {
        this.funciCargo = funciCargo;
    }

    public String getFunciCpf() {
        return funciCpf;
    }

    public void setFunciCpf(String funciCpf) {
        this.funciCpf = funciCpf;
    }
}
