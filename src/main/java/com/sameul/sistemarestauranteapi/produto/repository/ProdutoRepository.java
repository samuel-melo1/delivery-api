package com.sameul.sistemarestauranteapi.produto.repository;

import com.sameul.sistemarestauranteapi.produto.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
