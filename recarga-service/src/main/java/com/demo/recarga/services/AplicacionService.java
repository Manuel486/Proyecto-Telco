package com.demo.recarga.services;

import com.demo.recarga.model.entities.Aplicacion;

import java.util.List;

public interface AplicacionService {
    public List<Aplicacion> listar();

    public Aplicacion guardar(Aplicacion aplicacion);

    public Aplicacion buscar(int id);

    public void eliminar(int id);

}
