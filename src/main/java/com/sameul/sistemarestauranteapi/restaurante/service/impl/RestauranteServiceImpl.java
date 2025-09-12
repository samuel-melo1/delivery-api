package com.sameul.sistemarestauranteapi.restaurante.service.impl;

import com.sameul.sistemarestauranteapi.common.exceptions.ObjectAlreadyExistException;
import com.sameul.sistemarestauranteapi.common.exceptions.ObjectNotFoundException;
import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteErrorCode;
import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteStatus;
import com.sameul.sistemarestauranteapi.restaurante.mapper.RestauranteMapper;
import com.sameul.sistemarestauranteapi.restaurante.repository.RestauranteRepository;
import com.sameul.sistemarestauranteapi.restaurante.request.RestauranteRequest;
import com.sameul.sistemarestauranteapi.restaurante.service.RestauranteService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    private final RestauranteRepository repository;
    private final RestauranteMapper mapper;
    public RestauranteServiceImpl(RestauranteRepository repository, RestauranteMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void salvar(RestauranteRequest dto){
        validarCnpjDuplicado(dto.getCnpj());
        Restaurante restaurante = new Restaurante(dto.getNome(), dto.getEndereco(), dto.getCnpj());
        repository.save(restaurante);
    }
    @Override
    public Page<RestauranteRequest> listarRestaurantes(int pageNumber, int pageSize, RestauranteStatus status){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Restaurante> restaurantes;
        if (status != RestauranteStatus.TODOS) {
            restaurantes = repository.findByStatus(status,pageable);
        }else{
            restaurantes = repository.findAll(pageable);
        }
        return restaurantes.map(mapper::toDto);
    }

    @Override
    @Transactional
    public void atualizar(RestauranteRequest dto, Integer id){
        Restaurante restaurante = findById(id);
        restaurante.setStatus(dto.getStatus());
        restaurante.setEndereco(dto.getEndereco());
        restaurante.setNome(dto.getNome());
        repository.save(restaurante);
    }

    @Override
    @Transactional
    public void alterarStatusRestaurante(int restauranteId, RestauranteStatus status){
        Restaurante restaurante = findById(restauranteId);
        restaurante.setStatus(status);
        repository.save(restaurante);
    }
    private void validarCnpjDuplicado(String cnpj){
        if (repository.existsRestauranteByCnpj(cnpj)) {
            throw new ObjectAlreadyExistException(RestauranteErrorCode.RESTAURANTE_JA_EXISTENTE);
        }
    }

    private Restaurante findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(RestauranteErrorCode.RESTAURANTE_NAO_ENCONTRADO));
    }

}
