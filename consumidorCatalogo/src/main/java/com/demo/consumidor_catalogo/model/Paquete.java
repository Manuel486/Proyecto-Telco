package com.demo.consumidor_catalogo.model;

import lombok.Data;

@Data
public class Paquete {

    private  Integer id;
    private String nombre;
    private Double precio;
    private Integer horas;
    private String detalle;
    private String imagen;
}

