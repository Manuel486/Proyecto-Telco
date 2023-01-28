package com.demo.recarga.services;

import com.demo.recarga.model.entities.Recarga;

import java.util.List;

public interface RecargaService {
    public List<Recarga> listar();

    public Recarga guardar(Recarga recarga);

    public Recarga buscar(int id);

    public void eliminar(int id);

    public Recarga asignarAplicacion(int idRecarga,int idAplicacion);
}
