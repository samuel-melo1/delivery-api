package com.sameul.sistemarestauranteapi.mesa.dto.response;

import com.sameul.sistemarestauranteapi.mesa.enums.MesaStatus;

public class MesaResponse {

    private Integer numeroMesa;
    private MesaStatus status;
    public MesaResponse(){}
    public MesaResponse(Integer numeroMesa, MesaStatus status) {
        this.numeroMesa = numeroMesa;
        this.status = status;
    }
    public Integer getNumeroMesa() {
        return numeroMesa;
    }
    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
    public MesaStatus getStatus() {
        return status;
    }
    public void setStatus(MesaStatus status) {
        this.status = status;
    }
}
