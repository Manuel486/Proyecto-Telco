package com.demo.recarga.services;

import com.demo.recarga.model.daos.CompraDao;
import com.demo.recarga.model.entities.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompraServiceImpl implements CompraService{

    @Autowired
    private CompraDao compraDao;

    @Override
    public List<Compra> listar() {
        return compraDao.findAll();
    }

    @Override
    public Compra guardar(Compra compra) {
        return compraDao.save(compra);
    }

    @Override
    public Compra buscar(int id) {
        return compraDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        compraDao.deleteById(id);
    }
}
