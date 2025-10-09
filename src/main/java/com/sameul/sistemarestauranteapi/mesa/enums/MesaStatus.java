package com.sameul.sistemarestauranteapi.mesa.enums;
public enum MesaStatus {

    LIVRE("LIVRE"),
    OCUPADA("OCUPADA");

    private String status;
    MesaStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

}
