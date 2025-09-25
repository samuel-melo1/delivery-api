package com.sameul.sistemarestauranteapi.categoriaproduto.controller;

import com.sameul.sistemarestauranteapi.categoriaproduto.dto.request.CategoriaProdutoRequest;
import com.sameul.sistemarestauranteapi.categoriaproduto.dto.response.CategoriaProdutoResponse;
import com.sameul.sistemarestauranteapi.categoriaproduto.service.CategoriaProdutoService;
import com.sameul.sistemarestauranteapi.produto.dto.request.ProdutoRequest;
import com.sameul.sistemarestauranteapi.produto.dto.response.ProdutoResponse;
import com.sameul.sistemarestauranteapi.produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/categoria-produtos")
public class CategoriaProdutoController {

    private final CategoriaProdutoService service;
    public CategoriaProdutoController(CategoriaProdutoService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<CategoriaProdutoResponse> salvar(@RequestBody @Valid CategoriaProdutoRequest request){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        return ResponseEntity.created(uri).body(service.salvar(request));
    }
    @GetMapping
    public ResponseEntity<Page<CategoriaProdutoResponse>> listar(@RequestParam(defaultValue = "0") Integer page,
                                                                @RequestParam(defaultValue = "10") Integer size){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(page, size));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
