package com.sameul.sistemarestauranteapi.controller;

import com.sameul.sistemarestauranteapi.controller.request.RestauranteRequest;
import com.sameul.sistemarestauranteapi.service.RestauranteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestaurateController {

    private final RestauranteService service;
    public RestaurateController(RestauranteService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid RestauranteRequest request){
        service.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<RestauranteRequest>>listarRestaurantes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarRestaurantes());
    }
    @PutMapping("/{id}/ativar")
    public ResponseEntity<Void> ativar(@PathVariable Integer id) {
        service.alterarStatusRestaurante(id, 1);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}/inativar")
    public ResponseEntity<Void> inativar(@PathVariable Integer id) {
        service.alterarStatusRestaurante(id, 9);
        return ResponseEntity.noContent().build();
    }
}
