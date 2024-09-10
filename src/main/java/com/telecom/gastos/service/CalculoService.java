package com.telecom.gastos.service;

import com.telecom.gastos.client.AsignacionesClient;
import com.telecom.gastos.client.Empleados;
import com.telecom.gastos.repository.TabuladorRepository;
import com.telecom.gastos.repository.ViaticoRepository;
import com.telecom.gastos.request.CalculoRequest;
import com.telecom.gastos.model.Tabulador;
import com.telecom.gastos.model.Viatico;
import com.telecom.gastos.exception.ResourceNotFoundException;
import com.telecom.gastos.response.ViaticoResponse;
import com.telecom.gastos.response.external.CuadrillaResponse;
import com.telecom.gastos.response.external.ProyectoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculoService {

    @Autowired
    private TabuladorRepository tabuladorRepository;

    @Autowired
    private AsignacionesClient asignacionesClient;

    @Autowired
    private ViaticoRepository viaticoRepository;

    @Autowired
    private Empleados empleados;

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

        ProyectoResponse proyectoResponse = asignacionesClient.getProyectoByUUID(calculoRequest.getUuidProyecto());
        BigDecimal factorCobro = BigDecimal.valueOf(proyectoResponse.getFactorCobro());

        CuadrillaResponse cuadrillaResponse = empleados.getCuadrillaByUUID(calculoRequest.getUuidCuadrilla());
        BigDecimal factorCudrilla = BigDecimal.valueOf(cuadrillaResponse.getFactorCuadrilla());



        // Calcula el monto total del viatico
        BigDecimal monto = tabulador.getCostoDia()
                .multiply(new BigDecimal(calculoRequest.getDias()))
                .multiply(new BigDecimal(calculoRequest.getPersona()))
                .multiply(factorCobro)
                .multiply(factorCudrilla);
        return monto;

    }

}
