package com.telecom.gastos.client;


import com.telecom.gastos.response.external.CuadrillaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "empleados", url = "${clients.telecom.asignaciones.ms}", path = "/api/v1")
public interface EmpleadosClient {
    @GetMapping("/{uuid}")
    CuadrillaResponse getCuadrillaByUUID(@PathVariable("uuid") UUID uuid);
}
