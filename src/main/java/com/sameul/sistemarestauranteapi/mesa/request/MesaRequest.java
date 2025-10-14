package com.sameul.sistemarestauranteapi.mesa.request;

public class MesaRequest {
    private Integer numeroMesa;
    public MesaRequest(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    public Integer getNumeroMesa() {
        return numeroMesa;
    }
}
