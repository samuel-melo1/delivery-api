package com.sameul.sistemarestauranteapi.restaurante.service;

import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteStatus;
import com.sameul.sistemarestauranteapi.restaurante.request.RestauranteRequest;
import org.springframework.data.domain.Page;

public interface RestauranteService {

    void salvar(RestauranteRequest dto);
    Page<RestauranteRequest>  listarRestaurantes(int pageNumber, int pageSize, RestauranteStatus status);
    void atualizar(RestauranteRequest dto, Integer id);
    void alterarStatusRestaurante(int restauranteId, RestauranteStatus status);

}
