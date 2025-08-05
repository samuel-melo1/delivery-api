package com.sameul.sistemarestauranteapi.enums;

import lombok.AllArgsConstructor;

public enum ComandaStatus {
    ABERTA(1),
    FECHADA(2);

    private final Integer status;

     ComandaStatus(int status){
        this.status = status;
    }
    public Integer getStatus(){
        return status;
    }
}
