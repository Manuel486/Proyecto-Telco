package com.demo.recarga.model.daos;

import com.demo.recarga.model.entities.Aplicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AplicacionDao extends JpaRepository<Aplicacion,Integer> {
    public Aplicacion findByNombre(String nombre);
}
