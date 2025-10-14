package com.sameul.sistemarestauranteapi.mesa.entity;

import com.sameul.sistemarestauranteapi.comanda.entity.Comanda;
import com.sameul.sistemarestauranteapi.mesa.enums.MesaStatus;
import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Mesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_mesa", nullable = false, unique = true)
    private Integer numeroMesa;
    @Enumerated(EnumType.STRING)
    private MesaStatus status;
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
    @OneToMany
    @JoinColumn(name = "mesa_id")
    private List<Comanda> comandas;
    public Mesa(){}
    public Mesa(Integer numeroMesa) {
        this.status = MesaStatus.LIVRE;
        this.restaurante = getRestaurante();
        this.numeroMesa = numeroMesa;
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
    public Integer getNumeroMesa() {
        return numeroMesa;
    }
    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}
