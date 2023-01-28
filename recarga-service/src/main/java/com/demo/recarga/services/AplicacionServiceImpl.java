package com.demo.recarga.services;

import com.demo.recarga.model.daos.AplicacionDao;
import com.demo.recarga.model.entities.Aplicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicacionServiceImpl implements AplicacionService{

    @Autowired
    private AplicacionDao aplicacionDao;
    @Override
    public List<Aplicacion> listar() {
        return aplicacionDao.findAll();
    }

    @Override
    public Aplicacion guardar(Aplicacion aplicacion) {
        return aplicacionDao.save(aplicacion);
    }

    @Override
    public Aplicacion buscar(int id) {
        return aplicacionDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        aplicacionDao.deleteById(id);
    }
}
