package com.sameul.sistemarestauranteapi.restaurante.controller;

import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteStatus;
import com.sameul.sistemarestauranteapi.restaurante.request.RestauranteRequest;
import com.sameul.sistemarestauranteapi.restaurante.service.RestauranteService;
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
    public ResponseEntity<List<RestauranteRequest>>listarRestaurantes(@RequestParam(defaultValue = "TODOS") RestauranteStatus status){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarRestaurantes(status));
    }
    @PutMapping("/ativar/{id}")
    public ResponseEntity<Void> ativar(@PathVariable Integer id) {
        service.alterarStatusRestaurante(id, RestauranteStatus.ATIVO);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/inativar/{id}")
    public ResponseEntity<Void> inativar(@PathVariable Integer id) {
        service.alterarStatusRestaurante(id, RestauranteStatus.INATIVO);
        return ResponseEntity.noContent().build();
    }
}
