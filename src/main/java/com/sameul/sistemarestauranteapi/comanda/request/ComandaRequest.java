package com.sameul.sistemarestauranteapi.comanda.request;

import com.sameul.sistemarestauranteapi.comanda.enums.ComandaStatus;
import com.sameul.sistemarestauranteapi.mesa.entity.Mesa;

public class ComandaRequest {

    private Mesa mesa;
    private ComandaStatus status;

    public ComandaRequest(){}
    public ComandaRequest(Mesa mesa, ComandaStatus status){}
    public Mesa getMesa() {
        return mesa;
    }
    public ComandaStatus getStatus() {
        return status;
    }

}
