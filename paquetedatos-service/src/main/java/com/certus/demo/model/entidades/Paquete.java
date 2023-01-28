package com.certus.demo.model.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@Getter
@Setter
@Document(collection = "paquetedatos")
public class Paquete {
    @Id
    private  Integer id;
    private String nombre;
    private Double precio;
    private Integer horas;
    private String detalle;
    private String imagen;
}
