package com.gestiondesclients.manager;

import com.gestiondesclients.model.Client;
import com.gestiondesclients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientManager {
    @Autowired
    private ClientRepository clientRepository;



    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    public void addNewClient(Client client) {
        clientRepository.save(client);
    }
    public void deleteClient(Long clientId) {
    clientRepository.deleteById(clientId);
    }

 
        @Transactional
        public void updateClient(Long clientId, Client client) {
            Client newClient = clientRepository.findById(clientId)
                    .orElseThrow(() -> new IllegalStateException("Client with id " + clientId + " not found!!!"));
            if (client.getNom() != null && client.getNom().length() > 0 && !Objects.equals(newClient.getNom(), client.getNom())) {
                newClient.setNom(client.getNom());
            }
            if (client.getCin() != null && !Objects.equals(newClient.getCin(), client.getCin())) {
                newClient.setCin(client.getCin());
            }
            if (client.getTel() != null && !Objects.equals(newClient.getTel(), client.getTel())) {
                newClient.setTel(client.getTel());
            }
        }
    }

