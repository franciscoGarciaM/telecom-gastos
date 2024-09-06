package com.telecom.gastos.service;

import com.telecom.gastos.model.Gasto;
import com.telecom.gastos.repository.GastoRepository;
import com.telecom.gastos.repository.ViaticoRepository;
import com.telecom.gastos.request.GastoRequest;
import com.telecom.gastos.model.Viatico;
import com.telecom.gastos.response.GastoResponse;
import com.telecom.gastos.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private ViaticoRepository viaticoRepository;

    private GastoResponse mappingEntityToresponse(Gasto gasto){
        GastoResponse gastoResponse = new GastoResponse();
        gastoResponse.setIdGasto(gasto.getId());
        gastoResponse.setFechaCambio(gasto.getFechaCambio());
        gastoResponse.setViatico(gasto.getViatico());
        gastoResponse.setUuidGasto(gasto.getUuidGasto());
        gastoResponse.setMonto(gasto.getMonto());
        return gastoResponse;
    }

    // Convierte LocalDate a Date
    public Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public GastoResponse creatGasto(GastoRequest gastoRequest) {
        Viatico viatico = viaticoRepository.findById(gastoRequest.getViatico())
                .orElseThrow(() -> new ResourceNotFoundException("Viatico no encontrado"));

        // Convierte LocalDate a Date para la fecha de cambio
        Date fechaCambio = convertToDate(LocalDate.now()); // O usa una fecha específica

        Gasto gasto = new Gasto(
                gastoRequest.getFechaInicio(),
                fechaCambio, // Asigna el valor convertido
                UUID.randomUUID(), // Genera un UUID
                gastoRequest.getMonto(),
                viatico
        );


        Gasto savedGasto = gastoRepository.save(gasto);
        return mappingEntityToresponse(savedGasto);
    }


        /*
    public ViaticoResponse creatViatico(ViaticoRequest viaticoRequest){
        Viatico viatico = new Viatico(
                viaticoRequest.getFechaInicio(),
                viaticoRequest.getFechaFin(),
                viaticoRequest.getMonto(),
                UUID.randomUUID()
        );
        Viatico savedViatico = viaticoRepository.save(viatico);
        return mappingEntityToResponse(savedViatico);
    }


        private ViaticoResponse mappingEntityToResponse(Viatico viatico){
        ViaticoResponse viaticoResponse = new ViaticoResponse();
        viaticoResponse.setFechaInicio(viatico.getFechaInicio());
        viaticoResponse.setUuidViatico(viatico.getUuidViatico());
        viaticoResponse.setMonto(viatico.getMonto());
        viaticoResponse.setFechaCambio(viatico.getFechaCambio());
        return viaticoResponse;
    }

    public ViaticoResponse creatViatico(ViaticoRequest viaticoRequest){
        Viatico viatico = new Viatico(
                viaticoRequest.getFechaInicio(),
                viaticoRequest.getFechaFin(),
                viaticoRequest.getMonto(),
                UUID.randomUUID()
        );
        Viatico savedViatico = viaticoRepository.save(viatico);
        return mappingEntityToResponse(savedViatico);
    }

    // Descuenta el monto del gasto del monto total del viatico
        BigDecimal nuevoMontoViatico = viatico.getMonto().subtract(gasto.getMonto());
        viatico.setMonto(nuevoMontoViatico);

        // Metodo para crear un gasto y descontarlo del viatico asociado
    public Gasto createGasto(GastoRequest gastoRequest) {
        // Busca el viatico asociado en la base de datos
        Viatico viatico = viaticoRepository.findById(gastoRequest.getIdViatico())
                .orElseThrow(() -> new ResourceNotFoundException("Viatico no encontrado"));
        // Crea un nuevo gasto con la informacion proporcionada
        Gasto gasto = new Gasto();
        gasto.setFechaInicio(LocalDate.now());
        gasto.setFechaCambio(LocalDate.now());
        gasto.setUuidGasto(UUID.randomUUID());
        gasto.setMonto(gastoRequest.getMonto());
        gasto.setIdViatico(viatico);
        // Guarda el gasto en la base de datos
        Gasto savedGasto = gastoRepository.save(gasto);
        // Actualiza el viatico en la base de datos con el nuevo monto
        viaticoRepository.save(viatico);
        return savedGasto;
    }

         */


}
