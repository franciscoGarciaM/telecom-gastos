package com.telecom.gastos.controller;


import com.telecom.gastos.request.CalculoRequest;
import com.telecom.gastos.service.CalculoService;
import com.telecom.gastos.service.ViaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/viatico")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;
    @Autowired
    private ViaticoService viaticoService;



    @GetMapping("/calculo")
    public BigDecimal calculateViatico(@RequestParam(value = "id_entidad") Integer idEntidad,
                                             @RequestParam(value ="numero_dias") Integer numeroDias,
                                             @RequestParam(value = "numero_personas") Integer numeroPersonas) {
        return calculoService.calculateViatico(new CalculoRequest(idEntidad,
                numeroDias, numeroPersonas));
    }

    //add comnet git
    /*
     @Autowired
    private ViaticoService viaticoService;

    // Endpoint para obtener el cálculo de viáticos por idViatico
    @GetMapping("/{idViatico}")
    public ViaticoResponse getCalculoDeViatico(@PathVariable Integer idViatico) {
        return viaticoService.getViaticoById(idViatico);
    }

    // Endpoint para crear un viático (POST)
    @PostMapping
    public ViaticoResponse createViatico(@RequestBody ViaticoRequest viaticoRequest) {
        return viaticoService.createViatico(viaticoRequest);
    }


     */

    /*
    @GetMapping("/{idEstado}")
    public Tabulador getEstadoById(@PathVariable Integer idEstado) {
        return tabuladorService.getEstadoById(idEstado);
    }


     public Viatico getViaticoById(Integer idViatico) {
        return viaticoRepository.findById(idViatico)
                .orElseThrow(() -> new ResourceNotFoundException("Viatico no encontrado"));

    @GetMapping("/{idViatico}")
    public ResponseEntity<Viatico> getViaticoById(@PathVariable Integer idViatico) {
        Viatico viatico = viaticoService.getViaticoById(idViatico);
        return ResponseEntity.ok(viatico);
    }
    public Viatico getViaticoById(Integer idViatico) {
        return viaticoRepository.findById(idViatico)
                .orElseThrow(() -> new ResourceNotFoundException("Viatico no encontrado"));
    }


    public Viatico getViaticoById(Integer idViatico) {
        return viaticoRepository.findById(idViatico)
                .orElseThrow(() -> new ResourceNotFoundException("Viatico no encontrado"));

    @GetMapping("/usuarios/{uuid}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(
            @PathVariable(value = "uuid") UUID uuid)
            throws ResourceNotFoundException {
        UsuarioResponse usuario = usuarioService.findByUuid(uuid);
        return ResponseEntity.ok().body(usuario);
    }

    }

     */

}
