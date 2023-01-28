package com.demo.recarga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RecargaServicioSinEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecargaServicioSinEurekaApplication.class, args);
    }

}
