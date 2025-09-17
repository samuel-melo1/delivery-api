package com.sameul.sistemarestauranteapi.produto.entity;

import com.sameul.sistemarestauranteapi.categoriaproduto.entity.CategoriaProduto;
import com.sameul.sistemarestauranteapi.produto.enums.ProdutoStatus;
import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Builder
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Float preco;
    @Enumerated(EnumType.STRING)
    private ProdutoStatus status;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaProduto categoria;
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
    public Produto(String descricao, Float preco) {
        this.descricao = descricao;
        this.preco = preco;
    }
    public Produto(Integer id, String descricao, Float preco, ProdutoStatus status, CategoriaProduto categoria, Restaurante restaurante) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
        this.categoria = categoria;
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
    public Float getPreco() {
        return preco;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    public ProdutoStatus getStatus() {
        return status;
    }
    public void setStatus(ProdutoStatus status) {
        this.status = status;
    }
    public CategoriaProduto getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }
    public Restaurante getRestaurante() {
        return restaurante;
    }
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
