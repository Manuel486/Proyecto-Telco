package com.certus.demo.service;

import com.certus.demo.model.daos.RedesRepository;
import com.certus.demo.model.entidades.Redes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedesServiceImpl implements RedesService {

    @Autowired
    private RedesRepository redesRepository;
    @Override
    public List<Redes> listar() {
        return redesRepository.findAll();
    }

    @Override
    public Redes guardar(Redes redes) {
        return redesRepository.save(redes);
    }

    @Override
    public Redes buscar(int id) {
        return redesRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        redesRepository.deleteById(id);
    }
}
