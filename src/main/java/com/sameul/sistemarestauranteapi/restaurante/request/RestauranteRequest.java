package com.sameul.sistemarestauranteapi.restaurante.request;
import com.sameul.sistemarestauranteapi.restaurante.enums.RestauranteStatus;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import java.io.Serializable;

public class RestauranteRequest implements Serializable {

    private Integer id;
    @NotBlank(message = "É necessário informar o nome do restaurante")
    private String nome;
    @NotBlank(message = "É necessário informar o CNPJ do restaurante")
    @CNPJ
    private String cnpj;
    private String endereco;
    private RestauranteStatus status;

    public RestauranteRequest(){}
    public RestauranteRequest(Integer id, String nome, String cnpj, String endereco, RestauranteStatus status) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.status = status;
    }
    public String getNome() {
        return nome;
    }
    public RestauranteStatus getStatus() {
        return status;
    }
    public String getCnpj() {
        return cnpj;
    }
    public String getEndereco() {
        return endereco;
    }
    public Integer getId(){
        return id;
    }
}
