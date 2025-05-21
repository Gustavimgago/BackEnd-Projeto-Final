package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PDD_ID")
    private Long pedidoId;

    //ID do Cliente, Total do Pedido

    @Column(name = "PDD_DATA_PEDIDO")
    private LocalDateTime pddDataPedido;

    @Size(max = 50, message = "Status deve ter no máximo 50 caracteres")
    @Column(name = "PDD_STATUS_PEDIDO")
    private String pddStatusPedido;

    @Column(name = "PDD_TOTAL_PEDIDO", nullable = false)
    private double pddTotalPedido;

    public Pedido() {
    }

    public Pedido(Long pedidoId, LocalDateTime pddDataPedido, String pddStatusPedido, double pddTotalPedido) {
        this.pedidoId = pedidoId;
        this.pddDataPedido = pddDataPedido;
        this.pddStatusPedido = pddStatusPedido;
        this.pddTotalPedido = pddTotalPedido;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public LocalDateTime getPddDataPedido() {
        return pddDataPedido;
    }

    public void setPddDataPedido(LocalDateTime pddDataPedido) {
        this.pddDataPedido = pddDataPedido;
    }

    public String getPddStatusPedido() {
        return pddStatusPedido;
    }

    public void setPddStatusPedido(String pddStatusPedido) {
        this.pddStatusPedido = pddStatusPedido;
    }

    public double getPddTotalPedido() {
        return pddTotalPedido;
    }

    public void setPddTotalPedido(double pddTotalPedido) {
        this.pddTotalPedido = pddTotalPedido;
    }
}
