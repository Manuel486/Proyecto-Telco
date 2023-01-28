package com.demo.consumidor_catalogo.controllers;

import com.demo.consumidor_catalogo.model.Paquete;
import com.demo.consumidor_catalogo.model.Recarga;
import com.demo.consumidor_catalogo.model.Redes;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/catalogo")
@RefreshScope
public class CatalogoController {

    @Autowired
    private RestTemplate restTemplate;

    // ---------------------------------------------------------------------------------------------
    // Recargas
    @CircuitBreaker(name = "recargaService", fallbackMethod = "fallbackGetRecargas")
    @GetMapping("/recargas")
    public List<Recarga> getRecargas(){
        String url ="http://demo-eureka-recarga/recarga";
        return restTemplate.exchange(url, HttpMethod.GET, null, ArrayList.class).getBody();
    }

    @CircuitBreaker(name = "recargaService", fallbackMethod = "fallbackGetRecarga")
    @GetMapping("/recargas/{id}")
    public Recarga getRecarga(@PathVariable int id){
        String url ="http://demo-eureka-recarga/recarga/"+id;
        return restTemplate.getForObject(url,Recarga.class);
    }

    @CircuitBreaker(name = "recargaService", fallbackMethod = "fallbackSaveRecarga")
    @PostMapping("/recargas")
    public Recarga saveRecarga(@RequestBody Recarga recarga){
        String url ="http://demo-eureka-recarga/recarga";
        return restTemplate.postForObject(url,recarga,Recarga.class);
    }

    @CircuitBreaker(name = "recargaService", fallbackMethod = "fallbackDeleteRecarga")
    @DeleteMapping("/recargas/{id}")
    public ResponseEntity<Void> deleteRecarga(@PathVariable int id){
        String url ="http://demo-eureka-recarga/recarga/"+id;
        return restTemplate.exchange(url,HttpMethod.DELETE,null,Void.class);
    }

    @CircuitBreaker(name = "recargaService", fallbackMethod = "fallbackPutRecarga")
    @PutMapping("/recargas/{id}")
    public ResponseEntity<Recarga> putRecarga(@PathVariable int id, @RequestBody Recarga recarga){
        String url ="http://demo-eureka-recarga/recarga/"+id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Recarga> entity = new HttpEntity<>(recarga, headers);
        return restTemplate.exchange(url,HttpMethod.PUT,entity,Recarga.class);
    }

    @CircuitBreaker(name = "recargaService", fallbackMethod = "fallbackasignarAplicacionARecarga")
    @PutMapping("/recargas/{idRecarga}/aplicacion/{idAplicacion}")
    public ResponseEntity<Recarga> asignarAplicacionARecarga(@PathVariable("idRecarga") int idRecarga,
                                                             @PathVariable("idAplicacion") int idAplicacion){
        String url ="http://demo-eureka-recarga/recarga/"+idRecarga+"/aplicacion/"+idAplicacion;
        return restTemplate.exchange(url,HttpMethod.PUT,null,Recarga.class);
    }

    public List<Recarga> fallbackGetRecargas(Throwable e) {
        return new ArrayList<>();
    }

    public Recarga fallbackGetRecarga(Throwable e) {
        System.out.println("Esta fallando el post");
        return new Recarga();
    }

    public Recarga fallbackSaveRecarga(Throwable e){
        return new Recarga();
    }

    // put y delete son de tipo void
    public ResponseEntity<Void> fallbackDeleteRecarga(int id, Throwable e) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Recarga> fallbackPutRecarga(int id,Recarga recarga,Throwable e){
        return new ResponseEntity<Recarga>(new Recarga(), HttpStatus.OK);
    }

    public ResponseEntity<Recarga> fallbackasignarAplicacionARecarga(int idRecarga,int idAplicacion,Throwable e){
        return new ResponseEntity<Recarga>(new Recarga(), HttpStatus.OK);
    }



    // ---------------------------------------------------------------------------------------------
    // Paquetes
    @CircuitBreaker(name = "paqueteService", fallbackMethod = "fallbackGetPaquetes")
    @GetMapping("/paquetes")
    public List<Paquete> getPaquetes(){
        String url ="http://demo-eureka-paquete/paquete";
        return restTemplate.exchange(url, HttpMethod.GET, null, ArrayList.class).getBody();
    }

    @CircuitBreaker(name = "paqueteService", fallbackMethod = "fallbackGetPaquete")
    @GetMapping("/paquetes/{id}")
    public Paquete getPaquete(@PathVariable int id){
        String url ="http://demo-eureka-paquete/paquete/"+id;
        return restTemplate.getForObject(url,Paquete.class);
    }

    @CircuitBreaker(name = "paqueteService", fallbackMethod = "fallbackSavePaquete")
    @PostMapping("/paquetes")
    public Paquete savePaquete(@RequestBody Paquete paquete){
        String url ="http://demo-eureka-paquete/paquete";
        return restTemplate.postForObject(url,paquete,Paquete.class);
    }

    @CircuitBreaker(name = "paqueteService", fallbackMethod = "fallbackDeletePaquete")
    @DeleteMapping("/paquetes/{id}")
    public ResponseEntity<Void> deletePaquete(@PathVariable int id){
        String url ="http://demo-eureka-paquete/paquete/"+id;
        return restTemplate.exchange(url,HttpMethod.DELETE,null,Void.class);
    }

    @CircuitBreaker(name = "paqueteService", fallbackMethod = "fallbackPutPaquete")
    @PutMapping("/paquetes/{id}")
    public ResponseEntity<Paquete> putPaquete(@PathVariable int id, @RequestBody Paquete paquete){
        String url ="http://demo-eureka-paquete/paquete/"+id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Paquete> entity = new HttpEntity<>(paquete, headers);
        return restTemplate.exchange(url,HttpMethod.PUT,entity,Paquete.class);
    }

    public List<Paquete> fallbackGetPaquetes(Throwable e) {
        return new ArrayList<>();
    }

    public Paquete fallbackGetPaquete(Throwable e) {
        return new Paquete();
    }

    public Paquete fallbackSavePaquete(Throwable e){
        return new Paquete();
    }

    // put y delete son de tipo void
    public ResponseEntity<Void> fallbackDeletePaquete(int id,Throwable e){
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Paquete> fallbackPutPaquete(int id,Paquete paquete,Throwable e){
        return new ResponseEntity<Paquete>(new Paquete(), HttpStatus.OK);
    }


    // ---------------------------------------------------------------------------------------------
    // Redes Sociales

    @CircuitBreaker(name = "redesService", fallbackMethod = "fallbackGetRedes")
    @GetMapping("/redes")
    public List<Redes> getRedes(){
        String url ="http://demo-eureka-redes/redes";
        return restTemplate.exchange(url, HttpMethod.GET, null, ArrayList.class).getBody();
    }

    @CircuitBreaker(name = "redesService", fallbackMethod = "fallbackGetRed")
    @GetMapping("/redes/{id}")
    public Redes getRedes(@PathVariable int id){
        String url ="http://demo-eureka-redes/redes/"+id;
        return restTemplate.getForObject(url,Redes.class);
    }

    @CircuitBreaker(name = "redesService", fallbackMethod = "fallbackSaveRedes")
    @PostMapping("/redes")
    public Redes saveRedes(@RequestBody Redes redes){
        String url ="http://demo-eureka-redes/redes";
        return restTemplate.postForObject(url,redes,Redes.class);
    }

    @CircuitBreaker(name = "redesService", fallbackMethod = "fallbackDeleteRedes")
    @DeleteMapping("/redes/{id}")
    public ResponseEntity<Void> deleteRedes(@PathVariable int id){
        String url ="http://demo-eureka-redes/redes/"+id;
        return restTemplate.exchange(url,HttpMethod.DELETE,null,Void.class);
    }

    @CircuitBreaker(name = "redesService", fallbackMethod = "fallbackPutRedes")
    @PutMapping("/redes/{id}")
    public ResponseEntity<Redes> putRedes(@PathVariable int id, @RequestBody Redes redes){
        String url ="http://demo-eureka-redes/redes/"+id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Redes> entity = new HttpEntity<>(redes, headers);
        return restTemplate.exchange(url,HttpMethod.PUT,entity,Redes.class);
    }

    public List<Redes> fallbackGetRedes(Throwable e) {
        return new ArrayList<>();
    }

    public Redes fallbackGetRed(Throwable e) {
        System.out.println("Esta fallando el post");
        return new Redes();
    }

    public Redes fallbackSaveRedes(Throwable e){
        return new Redes();
    }

    // put y delete son de tipo void
    public ResponseEntity<Void> fallbackDeleteRedes(int id, Throwable e) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Redes> fallbackPutRedes(int id,Redes redes,Throwable e){
        return new ResponseEntity<Redes>(new Redes(), HttpStatus.OK);
    }


}
