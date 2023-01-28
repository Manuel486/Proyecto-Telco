package com.demo.recarga.ws;

import com.demo.recarga.model.daos.AplicacionDao;
import com.demo.recarga.model.entities.Aplicacion;
import com.demo.recarga.model.entities.Recarga;
import com.demo.recarga.services.RecargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recarga")
@RefreshScope
public class RecargaRestController {

    @Autowired
    private RecargaService recargaService;

    @GetMapping("")
    public Iterable<Recarga> getRecargas(){
        return recargaService.listar();
    }

    @GetMapping("/{id}")
    public Recarga getRecarga(@PathVariable("id") int id){
        return recargaService.buscar(id);
    }

    @PostMapping("")
    public Recarga addRecarga(@RequestBody Recarga recarga){
        return recargaService.guardar(recarga);
    }

    @DeleteMapping("/{id}")
    public void deleteRecargar(@PathVariable("id") int id){
        recargaService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Recarga updateRecarga(@RequestBody Recarga recarga,@PathVariable("id") int id){
        return recargaService.guardar(recarga);
    }

    @PutMapping("/{idRecarga}/aplicacion/{idAplicacion}")
    public Recarga assignAplicacionARecarga(@PathVariable("idAplicacion") int idAplicacion,@PathVariable("idRecarga") int idRecarga){
        return recargaService.asignarAplicacion(idAplicacion,idRecarga);
    }

}
