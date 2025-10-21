package com.sameul.sistemarestauranteapi.mesa.dto.request;

public class MesaRequest {
    private Integer numeroMesa;
    public MesaRequest(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    public Integer getNumeroMesa() {
        return numeroMesa;
    }
    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}
