package com.sameul.sistemarestauranteapi.produto.controller;

import com.sameul.sistemarestauranteapi.produto.dto.request.ProdutoRequest;
import com.sameul.sistemarestauranteapi.produto.dto.response.ProdutoResponse;
import com.sameul.sistemarestauranteapi.produto.service.ProdutoService;
import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteStatus;
import com.sameul.sistemarestauranteapi.restaurante.request.RestauranteRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;
    public ProdutoController(ProdutoService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<ProdutoResponse> salvar(@RequestBody @Valid ProdutoRequest request){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        return ResponseEntity.created(uri).body(service.salvar(request));
    }
    @GetMapping
    public ResponseEntity<Page<ProdutoResponse>> listar(@RequestParam(defaultValue = "0") Integer page,
                                                                   @RequestParam(defaultValue = "10") Integer size){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(page, size));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
