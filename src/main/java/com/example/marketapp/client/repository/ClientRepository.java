package com.example.marketapp.client.repository;

import com.example.marketapp.client.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<ClientEntity, String> {
}
