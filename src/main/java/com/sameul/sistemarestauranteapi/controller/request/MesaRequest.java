package com.sameul.sistemarestauranteapi.controller.request;

import com.sameul.sistemarestauranteapi.entity.Restaurante;
import com.sameul.sistemarestauranteapi.enums.MesaStatus;

public class MesaRequest {

    private MesaStatus status;
    private Restaurante restaurante;

    public MesaRequest(MesaStatus status, Restaurante restaurante) {
        this.status = status;
        this.restaurante = restaurante;
    }

    public MesaStatus getStatus() {
        return status;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }
}
