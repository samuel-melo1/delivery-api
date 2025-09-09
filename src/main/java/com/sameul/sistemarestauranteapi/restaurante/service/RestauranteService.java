package com.sameul.sistemarestauranteapi.restaurante.service;

import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteStatus;
import com.sameul.sistemarestauranteapi.restaurante.repository.RestauranteRepository;
import com.sameul.sistemarestauranteapi.restaurante.request.RestauranteRequest;
import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import com.sameul.sistemarestauranteapi.common.exceptions.ObjectAlreadyExistException;
import com.sameul.sistemarestauranteapi.common.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteService {

    private final RestauranteRepository repository;
    public RestauranteService(RestauranteRepository repository){
        this.repository = repository;
    }

    public void salvar(RestauranteRequest dto){
        validarCnpjDuplicado(dto.getCnpj());
        Restaurante restaurante = new Restaurante(dto.getNome(), dto.getEndereco(), dto.getCnpj());
        repository.save(restaurante);
    }
    public List<RestauranteRequest> listarRestaurantes(RestauranteStatus status){
        List<Restaurante> restaurantes;
        if (status != RestauranteStatus.TODOS) {
            restaurantes = repository.findByStatus(status);
        }else{
            restaurantes = repository.findAll();
        }
        return restaurantes.stream()
                .map(restaurante -> new RestauranteRequest(restaurante.getId(), restaurante.getNome(),
                        restaurante.getCnpj(), restaurante.getEndereco(), restaurante.getStatus()))
                .collect(Collectors.toList());
    }
    public void alterarStatusRestaurante(int restauranteId, RestauranteStatus status){
        Restaurante restaurante = repository.findById(restauranteId)
                .orElseThrow(() -> new ObjectNotFoundException("Restaurante não encontrado no sistema"));

         restaurante.setStatus(status);
        repository.save(restaurante);
    }
    private void validarCnpjDuplicado(String cnpj){
        if (repository.existsRestauranteByCnpj(cnpj)) {
            throw new ObjectAlreadyExistException("Restaurante já está cadastrado no sistema");
        }
    }
}
