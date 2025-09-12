package com.sameul.sistemarestauranteapi.restaurante.mapper;

import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import com.sameul.sistemarestauranteapi.restaurante.request.RestauranteRequest;
import org.springframework.stereotype.Component;

@Component
public class RestauranteMapper {

    public Restaurante toEntity(RestauranteRequest dto) {
        return new Restaurante(dto.getNome(), dto.getEndereco(), dto.getCnpj());
    }
    public RestauranteRequest toDto(Restaurante restaurante) {
        RestauranteRequest dto = new RestauranteRequest();
        dto.setId(restaurante.getId());
        dto.setNome(restaurante.getNome());
        dto.setCnpj(restaurante.getCnpj());
        dto.setStatus(restaurante.getStatus());
        dto.setEndereco(restaurante.getEndereco());
        return dto;
    }
}
