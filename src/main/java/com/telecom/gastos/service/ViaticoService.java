package com.telecom.gastos.service;

import com.telecom.gastos.repository.ViaticoRepository;
import com.telecom.gastos.request.ViaticoRequest;
import com.telecom.gastos.model.Viatico;
import com.telecom.gastos.response.ViaticoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ViaticoService {

    @Autowired
    private ViaticoRepository viaticoRepository;


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







     /*

            private UsuarioResponse mappingEntityToResponse(Usuario usuario) {
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setNombre(usuario.getNombre());
        usuarioResponse.setNumEmpleado(usuario.getNumEmpleado());
        usuarioResponse.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioResponse.setFechaUltimoAccesso(usuario.getFechaUltimoAccesso());
        usuarioResponse.setPuesto(usuario.getPuesto());
        usuarioResponse.setIndActivo(usuario.getIndActivo());
        usuarioResponse.setNomUsuario(usuario.getNomUsuario());
        usuarioResponse.setUuid(usuario.getUuid());
        return usuarioResponse;
    }

    public UsuarioResponse createUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(
                UUID.randomUUID(),
                usuarioRequest.getNombre(),
                usuarioRequest.getNumEmpleado(),
                usuarioRequest.getFechaNacimiento(),
                new Date(), // Fecha del último acceso se puede inicializar con la fecha actual
                usuarioRequest.getPuesto(),
                usuarioRequest.getIndActivo(),
                usuarioRequest.getNomUsuario(),
                usuarioRequest.getPassword()
        );

        Usuario savedUsuario = usuarioRepository.save(usuario);
        return mappingEntityToResponse(savedUsuario);
    }




          public Viatico(LocalDate fechaInicio, LocalDate fechaCambio, BigDecimal monto, UUID uuidViatico) {
        this.fechaInicio = fechaInicio;
        this.fechaCambio = fechaCambio;
        this.monto = monto;
        this.uuidViatico = uuidViatico;
    }

         public UsuarioResponse createUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(
                UUID.randomUUID(),
                usuarioRequest.getNombre(),
                usuarioRequest.getNumEmpleado(),
                usuarioRequest.getFechaNacimiento(),
                new Date(), // Fecha del último acceso se puede inicializar con la fecha actual
                usuarioRequest.getPuesto(),
                usuarioRequest.getIndActivo(),
                usuarioRequest.getNomUsuario(),
                usuarioRequest.getPassword()
        );

        Usuario savedUsuario = usuarioRepository.save(usuario);
        return mappingEntityToResponse(savedUsuario);
    }


        @PostMapping
    public ViaticoResponse createViatico(@RequestBody ViaticoRequest viaticoRequest) {
        return viaticoService.createViatico(viaticoRequest);
    }


        @PostMapping("/usuarios")
    public ResponseEntity<UsuarioResponse> createUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse newUsuario = usuarioService.createUsuario(usuarioRequest);
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }

        // Crea la entidad Viatico
        Viatico viatico = new Viatico();
        viatico.setFechaInicio(LocalDate.now());
        viatico.setFechaCambio(LocalDate.now());
        viatico.setUuidViatico(UUID.randomUUID());
        viatico.setMonto(monto);
        Viatico savedViatico = viaticoRepository.save(viatico);
        return mappingEntityToResponse(savedViatico);
         */


}
