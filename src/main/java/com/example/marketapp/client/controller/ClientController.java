package com.example.marketapp.client.controller;

import com.example.marketapp.client.ClientService;
import com.example.marketapp.client.dto.ClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

     @GetMapping
     public List<ClientDto> getAllClients() {
         return clientService.getAllClients();
     }

        @GetMapping("/{id}")
        public ClientDto getClientById(String id) {
            return clientService.getClientById(id);
        }

    @PostMapping("/create")
    public ClientDto createClient(ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @PutMapping("/update/{id}")
    public ClientDto updateClient(String id, ClientDto clientDto) {
        return clientService.updateClient(id, clientDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(String id) {
        clientService.deleteClient(id);
    }
}
