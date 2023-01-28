package com.certus.demo.service;

import com.certus.demo.model.entidades.Redes;

import java.util.List;

public interface RedesService {

    public List<Redes> listar();

    public Redes guardar(Redes redes);

    public Redes buscar(int id);

    public void eliminar(int id);

}
