package com.sameul.sistemarestauranteapi.mesa.service;

import com.sameul.sistemarestauranteapi.mesa.request.MesaRequest;
import com.sameul.sistemarestauranteapi.mesa.entity.Mesa;
import com.sameul.sistemarestauranteapi.mesa.enums.MesaStatus;
import com.sameul.sistemarestauranteapi.mesa.repository.MesaRepository;
import com.sameul.sistemarestauranteapi.common.exceptions.ObjectNotFoundException;
import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteErrorCode;
import org.springframework.stereotype.Service;


public interface MesaService {
    void salvar(MesaRequest request);
    void alterarStatusMesa(int mesaId, MesaStatus status);
}
