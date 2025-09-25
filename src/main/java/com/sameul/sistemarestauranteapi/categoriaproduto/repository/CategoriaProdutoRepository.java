package com.sameul.sistemarestauranteapi.categoriaproduto.repository;

import com.sameul.sistemarestauranteapi.categoriaproduto.entity.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Integer> {
}
