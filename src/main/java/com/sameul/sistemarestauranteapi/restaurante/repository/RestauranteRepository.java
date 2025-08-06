package com.sameul.sistemarestauranteapi.restaurante.repository;

import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
    boolean existsRestauranteByCnpj(String cnpj);
}
