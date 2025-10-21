package com.sameul.sistemarestauranteapi.mesa.controller;

import com.sameul.sistemarestauranteapi.mesa.dto.request.MesaRequest;
import com.sameul.sistemarestauranteapi.mesa.dto.response.MesaResponse;
import com.sameul.sistemarestauranteapi.mesa.enums.MesaStatus;
import com.sameul.sistemarestauranteapi.mesa.service.MesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    private final MesaService mesaService;
    public MesaController(MesaService mesaService){
        this.mesaService = mesaService;
    }
    @GetMapping
    public ResponseEntity<List<MesaResponse>> getAll(){
        return ResponseEntity.ok(mesaService.getAll());
    }
    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody MesaRequest request){
        mesaService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/ocupar-mesa/{mesaId}")
    public ResponseEntity<MesaResponse> ocupar(@PathVariable Integer mesaId){
        MesaResponse response = mesaService.alterarStatusMesa(mesaId, MesaStatus.OCUPADA);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }
    @PutMapping("/liberar-mesa/{mesaId}")
    public ResponseEntity<MesaResponse> liberar(@PathVariable Integer mesaId){
        MesaResponse response = mesaService.alterarStatusMesa(mesaId, MesaStatus.LIVRE);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @DeleteMapping("/{mesaId}")
    public ResponseEntity<Void> deletar(@PathVariable Integer mesaId){
        mesaService.deletar(mesaId);
        return ResponseEntity.noContent().build();
    }

}
