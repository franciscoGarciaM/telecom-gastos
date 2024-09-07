package com.telecom.gastos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "gasto")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gasto_id_gen")
    @SequenceGenerator(name = "gasto_id_gen", sequenceName = "gasto_id_gasto_seq", allocationSize = 1)
    @Column(name = "id_gasto", nullable = false)
    private Integer id;


    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_cambio", nullable = false)
    private Date fechaCambio;

    @Column(name = "uuid_gasto", nullable = false)
    private UUID uuidGasto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_viatico", nullable = false)
    @JsonBackReference
    private Viatico viatico;



    public Gasto(Date fechaInicio, Date fechaCambio, UUID uuidGasto, BigDecimal monto, Viatico viatico) {
        this.fechaInicio = fechaInicio;
        this.fechaCambio = fechaCambio; // Se espera un Date aquí
        this.uuidGasto = uuidGasto;
        this.monto = monto;
        this.viatico = viatico;
    }




    public Gasto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public UUID getUuidGasto() {
        return uuidGasto;
    }

    public void setUuidGasto(UUID uuidGasto) {
        this.uuidGasto = uuidGasto;
    }

    public Viatico getViatico() {
        return viatico;
    }

    public void setViatico(Viatico idViatico) {
        this.viatico = idViatico;
    }

}