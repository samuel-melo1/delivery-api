package com.sameul.sistemarestauranteapi.mesa.mapper;

import com.sameul.sistemarestauranteapi.mesa.dto.response.MesaResponse;
import com.sameul.sistemarestauranteapi.mesa.entity.Mesa;
import com.sameul.sistemarestauranteapi.mesa.dto.request.MesaRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MesaMapper {

    Mesa requestToEntity(MesaRequest request);
    MesaRequest mesaEntityToRequest(Mesa mesa);
    MesaResponse mesaToResponse(Mesa mesa);
    Mesa responseToMesaEntity(MesaResponse response);
}
