package com.sameul.sistemarestauranteapi.comanda.enums;

import lombok.AllArgsConstructor;

public enum ComandaStatus {
    ABERTA(1),
    AGUARDANDO_PAGAMENTO(2),
    FECHADA(3);

    private final Integer status;

     ComandaStatus(int status){
        this.status = status;
    }
    public Integer getStatus(){
        return status;
    }
}
