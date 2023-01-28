package com.demo.consumidor_catalogo.model;

import lombok.Data;

import java.util.List;

@Data
public class Recarga {

    private int id;
    private String nombre;
    private double precio;
    private int dias;
    private String minutos;
    private int megabyte;
    private String imagen;
    private String detalle;
    private List<Aplicacion> aplicaciones;
}
