package com.sameul.sistemarestauranteapi.mesa.service.impl;

import com.sameul.sistemarestauranteapi.common.exceptions.ObjectNotFoundException;
import com.sameul.sistemarestauranteapi.mesa.entity.Mesa;
import com.sameul.sistemarestauranteapi.mesa.enums.MesaStatus;
import com.sameul.sistemarestauranteapi.mesa.repository.MesaRepository;
import com.sameul.sistemarestauranteapi.mesa.request.MesaRequest;
import com.sameul.sistemarestauranteapi.mesa.service.MesaService;
import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteErrorCode;
import org.springframework.stereotype.Service;

@Service
public class MesaServiceImpl implements MesaService {
    private final MesaRepository repository;
    public MesaServiceImpl(MesaRepository repository){
        this.repository = repository;
    }

    @Override
    public void salvar(MesaRequest request){
        try {
            Mesa mesa = new Mesa(request.getStatus(), request.getRestaurante());
            repository.save(mesa);
        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
    @Override
    public void alterarStatusMesa(int mesaId, MesaStatus status){
        Mesa mesa = repository.findById(mesaId)
                .orElseThrow(() -> new ObjectNotFoundException(RestauranteErrorCode.RESTAURANTE_NAO_ENCONTRADO));

        mesa.setStatus(status);
        repository.save(mesa);
    }
}
