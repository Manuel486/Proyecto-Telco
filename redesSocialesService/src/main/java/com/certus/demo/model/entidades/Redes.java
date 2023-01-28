package com.certus.demo.model.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "redesSociales")
public class Redes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String mensaje;
    private double precio;
    private int horas;
    private String descripcion;
    private String imagen;
}
