package com.demo.recarga.model.daos;

import com.demo.recarga.model.entities.Recarga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecargaDao extends JpaRepository<Recarga,Integer> {
}
