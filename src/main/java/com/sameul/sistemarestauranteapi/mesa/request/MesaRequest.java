package com.sameul.sistemarestauranteapi.mesa.request;

import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import com.sameul.sistemarestauranteapi.mesa.enums.MesaStatus;

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
