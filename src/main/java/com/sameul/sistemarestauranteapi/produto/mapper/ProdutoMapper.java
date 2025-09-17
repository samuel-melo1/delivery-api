package com.sameul.sistemarestauranteapi.produto.mapper;

import com.sameul.sistemarestauranteapi.produto.dto.request.ProdutoRequest;
import com.sameul.sistemarestauranteapi.produto.dto.response.ProdutoResponse;
import com.sameul.sistemarestauranteapi.produto.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProdutoMapper {
    Produto requestToEntity(ProdutoRequest request);
    ProdutoRequest produtoToRequest(Produto produto);
    ProdutoResponse produtoToResponse(Produto produto);
    Produto responseToProduto(ProdutoResponse response);
}
