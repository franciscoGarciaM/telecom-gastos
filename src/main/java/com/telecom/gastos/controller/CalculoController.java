package com.telecom.gastos.controller;


import com.telecom.gastos.request.CalculoRequest;
import com.telecom.gastos.service.CalculoService;
import com.telecom.gastos.service.ViaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/viatico")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;
    @Autowired
    private ViaticoService viaticoService;



    @GetMapping("/calculo")
    public BigDecimal calculateViaticos(@RequestParam(value = "id_entidad") Integer idEntidad,
                                             @RequestParam(value ="numero_dias") Integer numeroDias,
                                            @RequestParam(value = "uuid_proyecto") UUID uuidProyecto,
                                             @RequestParam(value = "uuid_cuadrilla") UUID uuidCuadrilla) {
        return calculoService.calculateViatico(new CalculoRequest(idEntidad,
                numeroDias, uuidProyecto, uuidCuadrilla));
    }
}
