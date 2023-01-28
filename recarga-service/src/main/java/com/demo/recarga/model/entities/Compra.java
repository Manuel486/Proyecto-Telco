package com.demo.recarga.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "recarga_id")
    Recarga recarga;

    private int id_cliente;
}
