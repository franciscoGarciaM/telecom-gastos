package com.telecom.gastos.request;

public class CalculoRequest {

        private Integer idEstado;
        private Integer dias;
        private Integer persona;

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

    public CalculoRequest(Integer idEstado, Integer dias, Integer persona) {
        this.idEstado = idEstado;
        this.dias = dias;
        this.persona = persona;
    }
}
