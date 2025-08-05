package com.sameul.sistemarestauranteapi.enums;
public enum MesaStatus {

    LIVRE(1),
    OCUPADA(2);

    private final int status;

    MesaStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return status;
    }

}
