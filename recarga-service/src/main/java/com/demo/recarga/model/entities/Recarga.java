package com.demo.recarga.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Recarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private double precio;
    private int dias;
    private String minutos;
    private int megabyte;
    private String imagen;
    private String detalle;
    @ManyToMany
    @JoinTable(name = "recargas_aplicaciones",
            joinColumns = @JoinColumn(name = "recarga_id"),
            inverseJoinColumns = @JoinColumn(name = "aplicacion_id"))
    private List<Aplicacion> aplicaciones;

}
