package com.sameul.sistemarestauranteapi.entity;

import com.sameul.sistemarestauranteapi.enums.MesaStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Mesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private MesaStatus status;
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
    @OneToMany
    @JoinColumn(name = "mesa_id")
    private List<Comanda> comandas;

    public Mesa(){}
    public Mesa(MesaStatus status, Restaurante restaurante) {
        this.status = status;
        this.restaurante = restaurante;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public MesaStatus getStatus() {
        return status;
    }
    public void setStatus(MesaStatus status) {
        this.status = status;
    }
    public Restaurante getRestaurante() {
        return restaurante;
    }
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    public List<Comanda> getComandas() {
        return comandas;
    }
    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }
}
