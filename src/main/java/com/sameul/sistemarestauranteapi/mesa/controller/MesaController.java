package com.sameul.sistemarestauranteapi.mesa.controller;

import com.sameul.sistemarestauranteapi.mesa.dto.request.MesaRequest;
import com.sameul.sistemarestauranteapi.mesa.dto.response.MesaResponse;
import com.sameul.sistemarestauranteapi.mesa.enums.MesaStatus;
import com.sameul.sistemarestauranteapi.mesa.service.MesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    private final MesaService mesaService;
    public MesaController(MesaService mesaService){
        this.mesaService = mesaService;
    }
    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody MesaRequest request){
        mesaService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/ocupar-mesa/{mesaId}")
    public ResponseEntity<MesaResponse> ocuparMesa(@PathVariable Integer mesaId){
        MesaResponse response = mesaService.alterarStatusMesa(mesaId, MesaStatus.OCUPADA);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
    @PutMapping("/liberar-mesa/{mesaId}")
    public ResponseEntity<MesaResponse> liberarMesa(@PathVariable Integer mesaId){
        MesaResponse response = mesaService.alterarStatusMesa(mesaId, MesaStatus.LIVRE);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
}
