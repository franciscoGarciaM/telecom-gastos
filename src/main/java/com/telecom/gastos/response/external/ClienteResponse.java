package com.telecom.gastos.response.external;

import java.io.Serializable;
import java.util.UUID;


public class ClienteResponse implements Serializable {

    private Integer id;

    private String nombreCliente;

    private UUID uuidCliente;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public UUID getUuidCliente() {
        return uuidCliente;
    }

    public void setUuidCliente(UUID uuidCliente) {
        this.uuidCliente = uuidCliente;
    }


}
