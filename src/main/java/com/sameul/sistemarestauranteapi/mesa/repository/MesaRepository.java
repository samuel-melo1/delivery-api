package com.sameul.sistemarestauranteapi.mesa.repository;

import com.sameul.sistemarestauranteapi.mesa.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {

    Optional<Mesa> findMesaByNumeroMesa(Integer numeroMesa);
}
