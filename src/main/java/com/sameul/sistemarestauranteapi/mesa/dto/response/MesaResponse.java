package com.sameul.sistemarestauranteapi.mesa.dto.response;

import com.sameul.sistemarestauranteapi.mesa.enums.MesaStatus;

public class MesaResponse {

    private Integer idMesa;
    private String nome;
    private MesaStatus status;
    public MesaResponse(){}
    public MesaResponse(Integer idMesa, String nome, MesaStatus status) {
        this.idMesa = idMesa;
        this.nome = nome;
        this.status = status;
    }
    public Integer getIdMesa() {
        return idMesa;
    }
    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public MesaStatus getStatus() {
        return status;
    }
    public void setStatus(MesaStatus status) {
        this.status = status;
    }
}
