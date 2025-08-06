package com.sameul.sistemarestauranteapi.comanda.entity;

import com.sameul.sistemarestauranteapi.mesa.entity.Mesa;
import com.sameul.sistemarestauranteapi.pedido.entity.Pedido;
import com.sameul.sistemarestauranteapi.comanda.enums.ComandaStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
@Entity
public class Comanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private ComandaStatus status;
    @OneToMany(mappedBy  = "comanda")
    private List<Pedido> pedidos;
    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    public Comanda(){}
    public Comanda(Mesa mesa){
        this.mesa = mesa;
        this.status = ComandaStatus.ABERTA;
    }
    public Comanda(Integer id, ComandaStatus status, List<Pedido> pedidos) {
        this.id = id;
        this.status = status;
        this.pedidos = pedidos;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public ComandaStatus getStatus() {
        return status;
    }
    public void setStatus(ComandaStatus status) {
        this.status = status;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
