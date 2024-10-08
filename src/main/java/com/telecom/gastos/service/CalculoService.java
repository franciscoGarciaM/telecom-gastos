package com.telecom.gastos.service;

import com.telecom.gastos.repository.TabuladorRepository;
import com.telecom.gastos.repository.ViaticoRepository;
import com.telecom.gastos.request.CalculoRequest;
import com.telecom.gastos.model.Tabulador;
import com.telecom.gastos.model.Viatico;
import com.telecom.gastos.exception.ResourceNotFoundException;
import com.telecom.gastos.response.ViaticoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculoService {

    @Autowired
    private TabuladorRepository tabuladorRepository;

    @Autowired
    private ViaticoRepository viaticoRepository;

    // Mtodo para mapear la entidad Viatico a la respuesta ViaticoResponse
    private ViaticoResponse mappingEntityToResponse(Viatico viatico) {
        ViaticoResponse viaticoResponse = new ViaticoResponse();
        viaticoResponse.setFechaInicio(viatico.getFechaInicio());
        viaticoResponse.setFechaCambio(viatico.getFechaCambio());
        viaticoResponse.setUuidViatico(viatico.getUuidViatico());
        viaticoResponse.setMonto(viatico.getMonto());
        return viaticoResponse;
    }

    // Metodo para crear un viatico a partir de un ViaticoRequest
    public BigDecimal calculateViatico(CalculoRequest calculoRequest) {
        // Busca el costo del estado en la tabla tabulador
        Tabulador tabulador = tabuladorRepository.findById(calculoRequest.getIdEstado())
                .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrado"));

        // Calcula el monto total del viatico
        BigDecimal monto = tabulador.getCostoDia()
                .multiply(new BigDecimal(calculoRequest.getDias()))
                .multiply(new BigDecimal(calculoRequest.getPersona()));
        return monto;

        /*
        // Crea la entidad Viatico
        Viatico viatico = new Viatico();
        viatico.setFechaInicio(LocalDate.now());
        viatico.setFechaCambio(LocalDate.now());
        viatico.setUuidViatico(UUID.randomUUID());
        viatico.setMonto(monto);
        Viatico savedViatico = viaticoRepository.save(viatico);
        return mappingEntityToResponse(savedViatico);
         */

        // Guarda el viatico en la base de datos


        // Retorna la respuesta mapeada

    }

}
