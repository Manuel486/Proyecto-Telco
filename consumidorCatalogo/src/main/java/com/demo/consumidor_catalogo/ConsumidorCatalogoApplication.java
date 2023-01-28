package com.demo.consumidor_catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ConsumidorCatalogoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumidorCatalogoApplication.class, args);
    }

}
