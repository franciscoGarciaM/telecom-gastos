package com.telecom.gastos.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tabulador")
public class Tabulador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tabulador_id_gen")
    @SequenceGenerator(name = "tabulador_id_gen", sequenceName = "tabulador_id_estado_seq", allocationSize = 1)
    @Column(name = "id_estado", nullable = false)
    private Integer id;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "costo_dia", nullable = false, precision = 12, scale = 2)
    private BigDecimal costoDia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getCostoDia() {
        return costoDia;
    }

    public void setCostoDia(BigDecimal costoDia) {
        this.costoDia = costoDia;
    }

}