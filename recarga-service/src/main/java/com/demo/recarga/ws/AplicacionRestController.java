package com.demo.recarga.ws;

import com.demo.recarga.model.entities.Aplicacion;
import com.demo.recarga.model.entities.Recarga;
import com.demo.recarga.services.AplicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aplicacion")
public class AplicacionRestController {

    @Autowired
    private AplicacionService aplicacionService;

    @GetMapping("")
    public Iterable<Aplicacion> getAplicaciones(){
        return aplicacionService.listar();
    }

    @GetMapping("/{id}")
    public Aplicacion getAplicacion(@PathVariable("id") int id){
        return aplicacionService.buscar(id);
    }

    @PostMapping("")
    public Aplicacion addAplicacion(@RequestBody Aplicacion aplicacion){
        return aplicacionService.guardar(aplicacion);
    }

    @DeleteMapping("/{id}")
    public void deleteAplicacion(@PathVariable("id") int id){
        aplicacionService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Aplicacion updateAplicacion(@RequestBody Aplicacion aplicacion,@PathVariable("id") int id){
        return aplicacionService.guardar(aplicacion);
    }
}
