package com.demo.recarga.services;

import com.demo.recarga.model.daos.AplicacionDao;
import com.demo.recarga.model.daos.RecargaDao;
import com.demo.recarga.model.entities.Aplicacion;
import com.demo.recarga.model.entities.Recarga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RecargaServiceImpl implements RecargaService {

    @Autowired
    private RecargaDao recargaDao;

    @Autowired
    private AplicacionDao aplicacionDao;
    @Override
    public List<Recarga> listar() {
        return recargaDao.findAll();
    }

    @Override
    public Recarga guardar(Recarga recarga) {
        return recargaDao.save(recarga);
    }

    @Override
    public Recarga buscar(int id) {
        return recargaDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        recargaDao.deleteById(id);
    }

    @Override
    public Recarga asignarAplicacion(int idAplicacion, int idRecarga) {
        List<Aplicacion> aplicacionSet=null;
        Recarga recarga = recargaDao.findById(idRecarga).orElse(null);
        Aplicacion aplicacion = aplicacionDao.findById(idAplicacion).orElse(null);
        aplicacionSet =  recarga.getAplicaciones();
        aplicacionSet.add(aplicacion);
        recarga.setAplicaciones(aplicacionSet);
        return recargaDao.save(recarga);
    }
}
