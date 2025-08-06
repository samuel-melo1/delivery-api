package com.sameul.sistemarestauranteapi.restaurante.service;

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
        validarCpfDuplicado(dto.getCnpj());
        Restaurante restaurante = new Restaurante(dto.getNome(), dto.getEndereco(), dto.getCnpj());
        repository.save(restaurante);
    }
    public List<RestauranteRequest> listarRestaurantes(){
        List<Restaurante> restaurantes = repository.findAll();
        return restaurantes.stream()
                .map(restaurante -> new RestauranteRequest(restaurante.getNome(),
                        restaurante.getCnpj(), restaurante.getEndereco()))
                .collect(Collectors.toList());
    }
    public void alterarStatusRestaurante(int restauranteId, int status){
        Restaurante restaurante = repository.findById(restauranteId)
                .orElseThrow(() -> new ObjectNotFoundException("Restaurante não encontrado no sistema"));

        restaurante.setStatus(status);
        repository.save(restaurante);
    }
    private void validarCpfDuplicado(String cnpj){
        if (repository.existsRestauranteByCnpj(cnpj)) {
            throw new ObjectAlreadyExistException("Restaurante já está cadastrado no sistema");
        }
    }
}
