package com.sameul.sistemarestauranteapi.service;

import com.sameul.sistemarestauranteapi.controller.request.MesaRequest;
import com.sameul.sistemarestauranteapi.entity.Mesa;
import com.sameul.sistemarestauranteapi.enums.MesaStatus;
import com.sameul.sistemarestauranteapi.repository.MesaRepository;
import com.sameul.sistemarestauranteapi.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MesaService {

    private final MesaRepository repository;

    public MesaService(MesaRepository repository){
        this.repository = repository;
    }

    public void salvar(MesaRequest request){
        try {
            Mesa mesa = new Mesa(request.getStatus(), request.getRestaurante());
            repository.save(mesa);
        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    public void alterarStatusMesa(int mesaId, MesaStatus status){
        Mesa mesa = repository.findById(mesaId).orElseThrow(
                () -> new ObjectNotFoundException("Mesa inválida ou não encontrada"));

        mesa.setStatus(status);
        repository.save(mesa);
    }
}
