package com.demo.recarga.model.daos;

import com.demo.recarga.model.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraDao extends JpaRepository<Compra,Integer> {
}
