package com.sameul.sistemarestauranteapi.mesa.service.impl;

import com.sameul.sistemarestauranteapi.common.exceptions.ObjectNotFoundException;
import com.sameul.sistemarestauranteapi.mesa.dto.response.MesaResponse;
import com.sameul.sistemarestauranteapi.mesa.entity.Mesa;
import com.sameul.sistemarestauranteapi.mesa.enums.MesaErrorCode;
import com.sameul.sistemarestauranteapi.mesa.enums.MesaStatus;
import com.sameul.sistemarestauranteapi.mesa.mapper.MesaMapper;
import com.sameul.sistemarestauranteapi.mesa.repository.MesaRepository;
import com.sameul.sistemarestauranteapi.mesa.dto.request.MesaRequest;
import com.sameul.sistemarestauranteapi.mesa.service.MesaService;
import com.sameul.sistemarestauranteapi.produto.service.impl.ProdutoServiceImpl;
import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteErrorCode;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {
    private final MesaRepository repository;
    private final MesaMapper mapper;
    private static final Logger log = LoggerFactory.getLogger(ProdutoServiceImpl.class);
    public MesaServiceImpl(MesaRepository repository, MesaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void salvar(MesaRequest request){
        log.info("Criando mesa. Número mesa: {}", request.getNumeroMesa());
        Mesa mesa = new Mesa(request.getNumeroMesa());
        repository.save(mesa);
    }
    @Override
    public MesaResponse alterarStatusMesa(int mesaId, MesaStatus status){
        Optional<Mesa> mesa = buscarPorNumero(mesaId);
        if (mesa.isEmpty()) {
            throw new ObjectNotFoundException(MesaErrorCode.MESA_NAO_ENCONTRADA);
        }

        mesa.get().setStatus(status);
        repository.save(mesa.get());

        return mapper.mesaToResponse(mesa.get());
    }
    @Override
    @Transactional
    public void deletar(int mesaId) {
        Optional<Mesa> mesa = buscarPorNumero(mesaId);
        if (mesa.isEmpty()) {
            throw new ObjectNotFoundException(MesaErrorCode.MESA_NAO_ENCONTRADA);
        }
        repository.delete(mesa.get());
    }
    private Optional<Mesa> buscarPorNumero(Integer numeroMesa){
        Optional<Mesa> mesa = repository.findMesaByNumeroMesa(numeroMesa);
        return mesa;
    }
}
