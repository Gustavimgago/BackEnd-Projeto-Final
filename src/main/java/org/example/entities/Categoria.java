package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
@Entity
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATE_ID")
    private Long cateId;

    @NotBlank(message = "Nome da categoria é obrigatório")
    @Size(max = 100, message = "Deve ter no máximo 100 caracteres")
    @Column(name = "CATE_NOME", nullable = false, length = 100)
    private String cateNome;

    @NotBlank(message = "Descrição é obrigatório")
    @Size(max = 100, message = "Deve ter no máximo 100 caracteres")
    @Column(name = "CATE_DESCRICAO", nullable = false, length = 100)
    private String cateDescricao;


    public Categoria() {
    }

    public Categoria(Long cateId, String cateNome, String cateDescricao) {
        this.cateId = cateId;
        this.cateNome = cateNome;
        this.cateDescricao = cateDescricao;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateNome() {
        return cateNome;
    }

    public void setCateNome(String cateNome) {
        this.cateNome = cateNome;
    }

    public String getCateDescricao() {
        return cateDescricao;
    }

    public void setCateDescricao(String cateDescricao) {
        this.cateDescricao = cateDescricao;
    }
}
