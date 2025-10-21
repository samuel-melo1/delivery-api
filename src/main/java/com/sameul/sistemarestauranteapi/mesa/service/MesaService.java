package com.sameul.sistemarestauranteapi.mesa.service;

import com.sameul.sistemarestauranteapi.mesa.dto.request.MesaRequest;
import com.sameul.sistemarestauranteapi.mesa.dto.response.MesaResponse;
import com.sameul.sistemarestauranteapi.mesa.enums.MesaStatus;

import java.util.List;


public interface MesaService {

    List<MesaResponse> getAll();
    void salvar(MesaRequest request);
    MesaResponse alterarStatusMesa(int mesaId, MesaStatus status);
    void deletar(int mesaId);
}
