package com.example.marketapp.client;

import com.example.marketapp.client.dto.ClientDto;

import java.util.List;

public interface ClientService {

     ClientDto createClient(ClientDto clientDto);
     ClientDto getClientById(String id);
     List<ClientDto> getAllClients();
     ClientDto updateClient(String id, ClientDto clientDto);
     void deleteClient(String id);
}
