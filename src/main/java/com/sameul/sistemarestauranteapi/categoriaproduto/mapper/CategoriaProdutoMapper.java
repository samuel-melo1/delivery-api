package com.sameul.sistemarestauranteapi.categoriaproduto.mapper;

import com.sameul.sistemarestauranteapi.categoriaproduto.dto.request.CategoriaProdutoRequest;
import com.sameul.sistemarestauranteapi.categoriaproduto.dto.response.CategoriaProdutoResponse;
import com.sameul.sistemarestauranteapi.categoriaproduto.entity.CategoriaProduto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaProdutoMapper {

    CategoriaProduto requestToEntity(CategoriaProdutoRequest request);
    CategoriaProdutoRequest categoriaProdutoToRequest(CategoriaProduto categoriaProduto);
    CategoriaProdutoResponse categoriaProdutoToResponse(CategoriaProduto categoriaProduto);
    CategoriaProduto responseToCategoriaProduto(CategoriaProdutoResponse response);
}
