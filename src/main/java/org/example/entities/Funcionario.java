package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FUNC_ID")
    private Long funciId;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome do funcionario deve ter no máximo 100 caracteres")
    @Column(name = "FUNCI_NOME", nullable = false, length = 100)
    private String funciNome;

    @NotBlank(message = "O cargo é obrigatório")
    @Size(max = 100, message = "Cargo deve ter no máximo 100 caracteres")
    @Column(name = "FUNCI_CARGO", nullable = false, length = 100)
    private String funciCargo;

    @NotBlank(message = "O email é obrigatório")
    @Size(max = 100, message = "O email deve ter no máximo 100 caracteres")
    @Column(name = "FUNCI_EMAIL", nullable = false, length = 100)
    private String funciEmail;

    @NotBlank(message = "Telefone é obrigatório")
    @Size(max = 100, message = "O telefone deve ter no máximo 100 caracteres")
    @Column(name = "FUNCI_TELEFONE", nullable = false, length = 100)
    private String funciTelefone;

    public Funcionario() {
    }

    public Funcionario(Long funciId, String funciNome, String funciCargo, String funciEmail, String funciTelefone) {
        this.funciId = funciId;
        this.funciNome = funciNome;
        this.funciCargo = funciCargo;
        this.funciEmail = funciEmail;
        this.funciTelefone = funciTelefone;
    }

    public Long getFunciId() {
        return funciId;
    }

    public void setFunciId(Long funciId) {
        this.funciId = funciId;
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

    public String getFunciEmail() {
        return funciEmail;
    }

    public void setFunciEmail(String funciEmail) {
        this.funciEmail = funciEmail;
    }

    public String getFunciTelefone() {
        return funciTelefone;
    }

    public void setFunciTelefone(String funciTelefone) {
        this.funciTelefone = funciTelefone;
    }
}
