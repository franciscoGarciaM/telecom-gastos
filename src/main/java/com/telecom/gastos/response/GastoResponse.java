package com.telecom.gastos.response;

import com.telecom.gastos.model.Viatico;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class GastoResponse {
    private Integer idGasto;
    private BigDecimal monto;
    private Date fechaInicio;
    private Date fechaCambio;
    private UUID uuidGasto;
    private Viatico viatico;

    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
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

    public void setViatico(Viatico viatico) {
        this.viatico = viatico;
    }
}
