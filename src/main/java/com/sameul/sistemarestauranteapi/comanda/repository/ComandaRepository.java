package com.sameul.sistemarestauranteapi.comanda.repository;

import com.sameul.sistemarestauranteapi.comanda.entity.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComandaRepository extends JpaRepository<Comanda, Integer> {
}
