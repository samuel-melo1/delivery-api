package com.sameul.sistemarestauranteapi.restaurante.controller;

import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteStatus;
import com.sameul.sistemarestauranteapi.restaurante.request.RestauranteRequest;
import com.sameul.sistemarestauranteapi.restaurante.service.RestauranteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<RestauranteRequest>>listarRestaurantes(@RequestParam(defaultValue = "TODOS") RestauranteStatus status,
                                                                      @RequestParam(defaultValue = "0") Integer page,
                                                                      @RequestParam(defaultValue = "10") Integer size){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarRestaurantes(page, size, status));
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody @Valid RestauranteRequest dto, @PathVariable Integer id) {
        service.atualizar(dto, id);
        return ResponseEntity.noContent().build();
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
