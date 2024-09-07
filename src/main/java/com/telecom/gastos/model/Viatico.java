package com.telecom.gastos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "viatico")
public class Viatico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viatico_id_gen") // o GenerationType.AUTO
    @SequenceGenerator(name = "viatico_id_gen", sequenceName = "viatico_id_viatico_seq", allocationSize = 1)
    @Column(name = "id_viatico")
    private Integer id;


    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_cambio", nullable = false)
    private Date fechaCambio;

    @Column(name = "uuid_viatico", nullable = false)
    private UUID uuidViatico;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @JsonManagedReference
    @OneToMany(mappedBy = "viatico")
    private Set<Gasto> gastos = new LinkedHashSet<>();

    public Viatico(Date fechaInicio, Date fechaCambio, BigDecimal monto, UUID uuidViatico) {
        this.fechaInicio = fechaInicio;
        this.fechaCambio = fechaCambio;
        this.monto = monto;
        this.uuidViatico = uuidViatico;
    }

    public Viatico() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public UUID getUuidViatico() {
        return uuidViatico;
    }

    public void setUuidViatico(UUID uuidViatico) {
        this.uuidViatico = uuidViatico;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Set<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(Set<Gasto> gastos) {
        this.gastos = gastos;
    }

}