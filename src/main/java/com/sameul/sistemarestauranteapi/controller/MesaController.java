package com.sameul.sistemarestauranteapi.controller;

import com.sameul.sistemarestauranteapi.controller.request.MesaRequest;
import com.sameul.sistemarestauranteapi.enums.MesaStatus;
import com.sameul.sistemarestauranteapi.service.MesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Void> ocuparMesa(@PathVariable Integer mesaId){
        mesaService.alterarStatusMesa(mesaId, MesaStatus.OCUPADA);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/liberar-mesa/{mesaId}")
    public ResponseEntity<Void> liberarMesa(@PathVariable Integer mesaId){
        mesaService.alterarStatusMesa(mesaId, MesaStatus.LIVRE);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
