package com.sameul.sistemarestauranteapi.categoriaproduto.entity;

import com.sameul.sistemarestauranteapi.categoriaproduto.enums.CategoriaProdutoStatus;
import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Builder
public class CategoriaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private CategoriaProdutoStatus status;
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    public CategoriaProduto(){}
    public CategoriaProduto(Integer id, String descricao, CategoriaProdutoStatus status, Restaurante restaurante) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.restaurante = restaurante;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaProdutoStatus getStatus() {
        return status;
    }

    public void setStatus(CategoriaProdutoStatus status) {
        this.status = status;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
