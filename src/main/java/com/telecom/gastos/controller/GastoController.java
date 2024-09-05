package com.telecom.gastos.controller;

import com.telecom.gastos.request.GastoRequest;
import com.telecom.gastos.service.GastoService;
import com.telecom.gastos.response.GastoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gasto")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @PostMapping
    public GastoResponse creatGasto(@RequestBody GastoRequest gastoRequest) {
        return gastoService.creatGasto(gastoRequest);
    }

}