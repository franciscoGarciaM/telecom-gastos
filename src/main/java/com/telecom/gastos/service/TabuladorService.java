package com.telecom.gastos.service;

import com.telecom.gastos.repository.TabuladorRepository;
import com.telecom.gastos.model.Tabulador;
import com.telecom.gastos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TabuladorService {
    @Autowired
    private TabuladorRepository tabuladorRepository;

    public List<Tabulador> getAllEstados() {
        return tabuladorRepository.findAll();
    }

    public Tabulador getEstadoById(Integer idEstado) {
        return tabuladorRepository.findById(idEstado)
                .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrado"));
    }
}
