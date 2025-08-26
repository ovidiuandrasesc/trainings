package com.example.marketapp.client.mapper;

import com.example.marketapp.client.dto.ClientDto;
import com.example.marketapp.client.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto toDto(ClientEntity clientEntity);
    ClientEntity toEntity(ClientDto clientDto);

}
