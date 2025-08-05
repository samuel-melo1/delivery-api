package com.sameul.sistemarestauranteapi.controller.request;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import java.io.Serializable;

public class RestauranteRequest implements Serializable {

    @NotBlank(message = "É necessário informar o nome do restaurante")
    private String nome;
    @NotBlank(message = "É necessário informar o CNPJ do restaurante")
    @CNPJ
    private String cnpj;
    private String endereco;

    public RestauranteRequest(){}
    public RestauranteRequest(String nome, String cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public String getEndereco() {
        return endereco;
    }
}
