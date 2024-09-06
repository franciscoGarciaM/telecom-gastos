package com.telecom.gastos.controller;

import com.telecom.gastos.service.TabuladorService;
import com.telecom.gastos.model.Tabulador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tabulador")
public class TabuladorController {

    @Autowired
    private TabuladorService tabuladorService;

    @GetMapping
    public List<Tabulador> getAllEstados() {
        return tabuladorService.getAllEstados();
    }

    @GetMapping("/{idEstado}")
    public Tabulador getEstadoById(@PathVariable Integer idEstado) {
        return tabuladorService.getEstadoById(idEstado);
    }
}