package com.sameul.sistemarestauranteapi.restaurante.enums;

public enum RestauranteStatus {
    ATIVO(1),
    INATIVO(9),
    TODOS(null); // usado apenas para filtro
    private final Integer codigo;
    RestauranteStatus(Integer codigo) {
        this.codigo = codigo;
    }
    public Integer getCodigo() {
        return codigo;
    }
}