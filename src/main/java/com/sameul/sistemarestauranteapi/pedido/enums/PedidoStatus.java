package com.sameul.sistemarestauranteapi.pedido.enums;

public enum PedidoStatus {

    PREPARANDO(1),
    PRONTO(2),
    ENTREGUE(3);

    private int status;

     PedidoStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return status;
    }
}
