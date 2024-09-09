package com.telecom.gastos.response.external;


import java.io.Serializable;
import java.util.UUID;

public class ProyectoResponse implements Serializable {
    private Integer id;

    private String nombreProyecto;
        private String liderProyecto;

    private ClienteResponse idClienteResponse;

    private UUID uuidProyecto;

    private Double factorCobro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getLiderProyecto() {
        return liderProyecto;
    }

    public void setLiderProyecto(String liderProyecto) {
        this.liderProyecto = liderProyecto;
    }

    public ClienteResponse getIdClienteResponse() {
        return idClienteResponse;
    }

    public void setIdClienteResponse(ClienteResponse idClienteResponse) {
        this.idClienteResponse = idClienteResponse;
    }

    public UUID getUuidProyecto() {
        return uuidProyecto;
    }

    public void setUuidProyecto(UUID uuidProyecto) {
        this.uuidProyecto = uuidProyecto;
    }

    public Double getFactorCobro() {
        return factorCobro;
    }

    public void setFactorCobro(Double factorCobro) {
        this.factorCobro = factorCobro;
    }
}

