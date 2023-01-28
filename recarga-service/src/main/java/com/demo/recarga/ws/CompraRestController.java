package com.demo.recarga.ws;

import com.demo.recarga.model.entities.Compra;
import com.demo.recarga.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class CompraRestController {

    @Autowired
    private CompraService compraService;

    @GetMapping("")
    public Iterable<Compra> getCompras(){
        return compraService.listar();
    }

    @GetMapping("/{id}")
    public Compra getCompra(@PathVariable("id") int id){
        return compraService.buscar(id);
    }

    @PostMapping("")
    public Compra addCompra(@RequestBody Compra compra){
        return compraService.guardar(compra);
    }

    @DeleteMapping("/{id}")
    public void deleteCompra(@PathVariable("id") int id){
        compraService.eliminar(id);
    }

    @PutMapping("/{id}")
    public Compra updateCompra(@RequestBody Compra compra,@PathVariable("id") int id){
        return compraService.guardar(compra);
    }
}
