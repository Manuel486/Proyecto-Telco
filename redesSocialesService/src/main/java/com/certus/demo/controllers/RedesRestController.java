package com.certus.demo.controllers;

import com.certus.demo.model.entidades.Redes;
import com.certus.demo.service.RedesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redes")
public class RedesRestController {

    @Autowired
    private RedesService redesService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Redes> getAllRedes(){
        return redesService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Redes getRedes (@PathVariable Integer id){
        return redesService.buscar(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Redes addRedes (@RequestBody Redes redes){
        return redesService.guardar(redes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRedes(@PathVariable("id") int id){
    redesService.eliminar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Redes updateRedes (@RequestBody Redes redes,@PathVariable("id") int id){
    return redesService.guardar(redes);
    }
}
