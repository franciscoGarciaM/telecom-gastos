package com.telecom.gastos.request;

import java.math.BigDecimal;
import java.util.Date;

public class GastoRequest {

        private Integer Viatico;
        private BigDecimal monto;
        private Date fechaInicio;
        private Date fechaFin;

        // Getters y Setters


    public Integer getViatico() {
        return Viatico;
    }

    public void setViatico(Integer viatico) {
        Viatico = viatico;
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

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
