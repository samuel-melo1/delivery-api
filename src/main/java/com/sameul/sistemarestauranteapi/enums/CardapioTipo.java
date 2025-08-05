package com.sameul.sistemarestauranteapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

public enum CardapioTipo {

    FIXO(1), SAZONAL(2), PROMOCIONAL(3);

    private int status;

     CardapioTipo(int status){
        this.status  = status;
    }
    public int getStatus(){
        return status;
    }
}
