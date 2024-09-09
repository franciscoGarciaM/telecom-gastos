package com.telecom.gastos.client;


import com.telecom.gastos.response.external.ProyectoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "asignacionesClient", url = "${clients.telecom.asignaciones.ms}", path = "/api/v1/proyectos")
public interface AsignacionesClient {

    @GetMapping("/{uuid}")
    ProyectoResponse getProyectoByUUID(@PathVariable("uuid") UUID uuid);
}
