package com.gestiondesclients;

import com.gestiondesclients.repository.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.gestiondesclients"})
public class GestionDesClients {
    public static void main(String[] args) {
        SpringApplication.run(GestionDesClients.class, args);
    }
}
