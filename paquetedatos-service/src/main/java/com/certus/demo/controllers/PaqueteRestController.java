package com.certus.demo.controllers;

import com.certus.demo.model.entidades.Paquete;
import com.certus.demo.model.daos.PaqueteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paquete")
@RequiredArgsConstructor
public class PaqueteRestController {

    @Autowired
    private PaqueteRepository dao;

    // http://demo-eureka-servicio/rest/datos/server
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Paquete> getAllPaquetes() {
        return dao.findAll();
    }

    // http://demo-eureka-servicio/rest/datos/server/paquete/1
    @GetMapping("/{id}")
    public Paquete getPaquete(@PathVariable Integer id) {
        return dao.findById(id).get();
    }

    // http://demo-eureka-servicio/rest/datos/server/paquete
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Paquete addPaquete(@RequestBody Paquete paquete) {
        return dao.save(paquete);
    }

    // http://demo-eureka-servicio/rest/cursos/server/paquete/1
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePaquete(@PathVariable Integer id) {
        dao.deleteById(id);
    }

    // http://demo-eureka-servicio/rest/cursos/server/cursos/{id}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Paquete updatePaquete(@RequestBody Paquete paquete, @PathVariable Integer id) {
        //paquete.id(id)
        return dao.save(paquete);
    }
}
