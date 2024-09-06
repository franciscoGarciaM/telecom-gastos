package com.telecom.gastos.controller;

import com.telecom.gastos.request.ViaticoRequest;
import com.telecom.gastos.service.ViaticoService;
import com.telecom.gastos.response.ViaticoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/viatico")
public class ViaticoController {
    @Autowired
    private ViaticoService viaticoService;


    @PostMapping("/in")
    public ViaticoResponse creatViatico(@RequestBody ViaticoRequest viaticoRequest) {
        return viaticoService.creatViatico(viaticoRequest);
    }

}
