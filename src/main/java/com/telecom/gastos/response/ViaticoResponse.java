package com.telecom.gastos.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class ViaticoResponse {

    private Date fechaInicio;
    private Date fechaCambio;
    private BigDecimal monto;
    private Integer idViato;
    private UUID uuidViatico;

    public Integer getIdViato() {
        return idViato;
    }

    public void setIdViato(Integer idViato) {
        this.idViato = idViato;
    }


    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {

        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCambio(Date fechaCambio) {
        return this.fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public UUID getUuidViatico() {
        return uuidViatico;
    }

    public void setUuidViatico(UUID uuidViatico) {
        this.uuidViatico = uuidViatico;
    }

}
