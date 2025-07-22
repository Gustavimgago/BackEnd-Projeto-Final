package org.example.DTO;

public class FuncionarioDTO {

    private Long funciId;
    private String funciNome;
    private String funciCargo;
    private String funciCpf;

    private String endRua;
    private String endNumero;
    private String endCidade;
    private String endCep;
    private String endEstado;


    private String conCelular;
    private String conTelefoneComercial;
    private String conEmail;

    public FuncionarioDTO() {
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

    public String getFunciCpf() {
        return funciCpf;
    }

    public void setFunciCpf(String funciCpf) {
        this.funciCpf = funciCpf;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndCidade() {
        return endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
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
