package com.demo.recarga.services;


import com.demo.recarga.model.entities.Compra;

import java.util.List;

public interface CompraService {
    public List<Compra> listar();

    public Compra guardar(Compra compra);

    public Compra buscar(int id);

    public void eliminar(int id);
}
