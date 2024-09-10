package com.telecom.gastos.request;

import java.util.UUID;

public class CalculoRequest {

        private Integer idEstado;
        private Integer dias;
        private Integer persona;
        private UUID uuidProyecto;
        private UUID uuidCuadrilla;

    public Integer getPersona() {
        return persona;
    }

    public void setPersona(Integer persona) {
        this.persona = persona;
    }

    // Getters y Setters

        public Integer getIdEstado() {
            return idEstado;
        }

        public void setIdEstado(Integer idEstado) {
            this.idEstado = idEstado;
        }

        public Integer getDias() {
            return dias;
        }

        public void setDias(Integer dias) {
            this.dias = dias;
        }

    public UUID getUuidProyecto() {
        return uuidProyecto;
    }

    public void setUuidProyecto(UUID uuidProyecto) {
        this.uuidProyecto = uuidProyecto;
    }

    public UUID getUuidCuadrilla() {
        return uuidCuadrilla;
    }

    public void setUuidCuadrilla(UUID uuidCuadrilla) {
        this.uuidCuadrilla = uuidCuadrilla;
    }

    public CalculoRequest(Integer idEstado, Integer dias, UUID uuidProyecto, UUID uuidCuadrilla) {
        this.idEstado = idEstado;
        this.dias = dias;
        this.uuidProyecto = uuidProyecto;
        this.uuidCuadrilla = uuidCuadrilla;
    }
}
