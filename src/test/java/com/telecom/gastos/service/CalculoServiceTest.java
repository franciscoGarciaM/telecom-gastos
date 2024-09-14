package com.telecom.gastos.service;

import com.telecom.gastos.client.AsignacionesClient;
import com.telecom.gastos.client.EmpleadosClient;
import com.telecom.gastos.model.Tabulador;
import com.telecom.gastos.repository.TabuladorRepository;
import com.telecom.gastos.request.CalculoRequest;
import com.telecom.gastos.response.external.CuadrillaResponse;
import com.telecom.gastos.response.external.ProyectoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculoServiceTest {


    @Mock
    private AsignacionesClient asignacionesClient;

    @Mock
    private EmpleadosClient empleadosClient;

    @Mock
    private TabuladorRepository tabuladorRepository;

    @InjectMocks
    private CalculoService calculoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateViatico_Success(){
        // 1. - ARRANGE (ORGANIZAR) Preparar Datos de Prueba, dependencias mocks y comportamientos de las dependencias
         CalculoRequest calculoRequest = new CalculoRequest(5,1
                 , UUID.fromString("a758b4e4-630c-440b-a7e9-ff9e1ec73f19"),UUID.fromString("36ae1df4-9626-4250-bd75-2e3fb0910733"));

        Tabulador tabulador = new Tabulador();
        tabulador.setCostoDia(new BigDecimal(450.0));

        ProyectoResponse proyectoResponse = new ProyectoResponse();
        proyectoResponse.setFactorCobro(1.0);

        CuadrillaResponse cuadrillaResponse = new CuadrillaResponse();
        cuadrillaResponse.setNumeroEmpleados(5);


        when(tabuladorRepository.findById(5)).thenReturn(Optional.of(tabulador)) ;

        when(asignacionesClient.getProyectoByUUID(UUID.fromString("a758b4e4-630c-440b-a7e9-ff9e1ec73f19"))).thenReturn(proyectoResponse);

        when(empleadosClient.getCuadrillaByUUID(UUID.fromString("36ae1df4-9626-4250-bd75-2e3fb0910733"))).thenReturn(cuadrillaResponse);


         BigDecimal montoEstimado = tabulador.getCostoDia()
                         .multiply(BigDecimal.valueOf(proyectoResponse.getFactorCobro()))
                       .multiply(BigDecimal.valueOf(cuadrillaResponse.getNumeroEmpleados()))
                      .multiply(BigDecimal.valueOf(calculoRequest.getDias()));


         //2.- ACT (ACTUAR)  Invocar el servicio que queremos probar
         BigDecimal monto = calculoService.calculateViatico(calculoRequest);

        //3.- ASSERT (Validar) Ejecutar Validaciones del resultado
        assertEquals(montoEstimado,monto);
    }
}
