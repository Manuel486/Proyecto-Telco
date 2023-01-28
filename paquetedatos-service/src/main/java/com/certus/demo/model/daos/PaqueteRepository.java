package com.certus.demo.model.daos;

import com.certus.demo.model.entidades.Paquete;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaqueteRepository extends MongoRepository<Paquete,Integer> {
}
