package com.sameul.sistemarestauranteapi.restaurante.service;

import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteStatus;
import com.sameul.sistemarestauranteapi.restaurante.repository.RestauranteRepository;
import com.sameul.sistemarestauranteapi.restaurante.request.RestauranteRequest;
import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import com.sameul.sistemarestauranteapi.common.exceptions.ObjectAlreadyExistException;
import com.sameul.sistemarestauranteapi.common.exceptions.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public Page<RestauranteRequest> listarRestaurantes(int pageNumber, int pageSize,RestauranteStatus status){
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Restaurante> restaurantes;
        if (status != RestauranteStatus.TODOS) {
            restaurantes = repository.findByStatus(status,pageable);
        }else{
            restaurantes = repository.findAll(pageable);
        }
        return restaurantes.map(this::convertToDto);
    }

    public void update(RestauranteRequest dto, Integer id){
        Restaurante restaurante = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Restaurante inválido ou não encontrado"));

        restaurante.setStatus(dto.getStatus());
        restaurante.setEndereco(dto.getEndereco());
        restaurante.setNome(dto.getNome());
        repository.save(restaurante);
    }

    public void alterarStatusRestaurante(int restauranteId, RestauranteStatus status){
        Restaurante restaurante = repository.findById(restauranteId)
                .orElseThrow(() -> new ObjectNotFoundException("Restaurante inválido ou não encontrado"));

         restaurante.setStatus(status);
        repository.save(restaurante);
    }
    private void validarCnpjDuplicado(String cnpj){
        if (repository.existsRestauranteByCnpj(cnpj)) {
            throw new ObjectAlreadyExistException("Restaurante já está cadastrado no sistema");
        }
    }

    private RestauranteRequest convertToDto(Restaurante restaurante) {
        RestauranteRequest dto = new RestauranteRequest();
        dto.setId(restaurante.getId());
        dto.setNome(restaurante.getNome());
        dto.setCnpj(restaurante.getCnpj());
        dto.setStatus(restaurante.getStatus());
        dto.setEndereco(restaurante.getEndereco());
        return dto;
    }
}
