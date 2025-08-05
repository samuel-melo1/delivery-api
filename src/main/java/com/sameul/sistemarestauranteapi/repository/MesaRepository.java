package com.sameul.sistemarestauranteapi.repository;

import com.sameul.sistemarestauranteapi.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {
}
