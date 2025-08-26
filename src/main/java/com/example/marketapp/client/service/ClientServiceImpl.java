package com.example.marketapp.client.service;

import com.example.marketapp.client.ClientService;
import com.example.marketapp.client.StripeCustomerService;
import com.example.marketapp.client.dto.ClientDto;
import com.example.marketapp.client.mapper.ClientMapper;
import com.example.marketapp.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;
    private final StripeCustomerService stripeCustomerService;

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        var clientEntity = mapper.toEntity(clientDto);
        String stripeCustomerId = getStripeCustomerId(clientDto);
        clientEntity.setStripeCustomerId(stripeCustomerId);

        clientEntity = repository.save(clientEntity);
        return mapper.toDto(clientEntity);
    }

    private String getStripeCustomerId(ClientDto clientDto) {
        try {
           return stripeCustomerService.createCustomer(clientDto.name(), clientDto.email(), clientDto.phoneNumber());
        } catch (Exception e) {
            System.err.println("Error creating Stripe customer: " + e.getMessage());
        }
        return null;
    }

    @Override
    public ClientDto getClientById(String id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public List<ClientDto> getAllClients() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public ClientDto updateClient(String id, ClientDto clientDto) {
        return repository.findById(id)
                .map(existingClientEntity -> {
                    var updatedClientEntity = mapper.toEntity(clientDto);
                    updatedClientEntity.setId(existingClientEntity.getId()); // Preserve the ID
                    updatedClientEntity = repository.save(updatedClientEntity);
                    return mapper.toDto(updatedClientEntity);
                })
                .orElse(null);
    }

    @Override
    public void deleteClient(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Client with ID " + id + " does not exist.");
        }
    }
}
