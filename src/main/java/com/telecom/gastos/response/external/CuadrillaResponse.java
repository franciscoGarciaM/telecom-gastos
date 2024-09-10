package com.telecom.gastos.response.external;

import java.io.Serializable;
import java.util.UUID;

public class CuadrillaResponse implements Serializable {
    private String nomEmpleado;
    private String puesto;
    private UUID uuidCuadrilla;
    private Double factorCuadrilla;

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public UUID getUuidCuadrilla() {
        return uuidCuadrilla;
    }

    public void setUuidCuadrilla(UUID uuidCuadrilla) {
        this.uuidCuadrilla = uuidCuadrilla;
    }

    public Double getFactorCuadrilla() {
        return factorCuadrilla;
    }

    public void setFactorCuadrilla(Double factorCuadrilla) {
        this.factorCuadrilla = factorCuadrilla;
    }
}
