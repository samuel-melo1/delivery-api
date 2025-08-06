package com.sameul.sistemarestauranteapi.pedido.entity;

import com.sameul.sistemarestauranteapi.comanda.entity.Comanda;
import com.sameul.sistemarestauranteapi.pedido.enums.PedidoStatus;
import com.sameul.sistemarestauranteapi.restaurante.entity.Restaurante;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataHora;
    private PedidoStatus status;
    private Float valorTotal;
    private Integer quantidadeTotal;
    @OneToMany
    @JoinColumn(name = "pedido_id")
    private List<PedidoItem> itens;
    @ManyToOne
    @JoinColumn(name = "comanda_id")
    private Comanda comanda;
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

}
