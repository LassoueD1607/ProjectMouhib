package com.gestiondesclients.controller;

import com.gestiondesclients.manager.ClientManager;
import com.gestiondesclients.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private  ClientManager clientManager;

    @GetMapping("/clients")
    public List<Client> getClients(){
        return clientManager.getClients();
    }


    @PostMapping("/clients")
    public void registerNewClient(@RequestBody Client client){
        clientManager.addNewClient(client);
    }


    @DeleteMapping(path="/clients/{clientId}")
        public void deleteClient(@PathVariable("clientId") Long clientId){
        clientManager.deleteClient(clientId);
    }

    @PutMapping(path = "/clients/{clientId}")
    public void updateClient(@PathVariable("clientId") Long clientId, @RequestBody Client client){
        clientManager.updateClient(clientId, client);
    }

}
