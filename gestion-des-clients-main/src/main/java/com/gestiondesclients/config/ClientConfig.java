package com.gestiondesclients.config;
import com.gestiondesclients.model.Client;
import com.gestiondesclients.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration

public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository repository){
        return args -> {
            Client amine=new Client(1L,"amine",11111111,20202020);
            Client yassine=new Client(2L,"yassine",22222222,20203030);
        repository.saveAll(List.of(amine,yassine));
        };
    }
}
