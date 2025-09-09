package com.sameul.sistemarestauranteapi.restaurante.repository;

import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
    boolean existsRestauranteByCnpj(String cnpj);

    List<Restaurante> findByStatus(RestauranteStatus status);
}
