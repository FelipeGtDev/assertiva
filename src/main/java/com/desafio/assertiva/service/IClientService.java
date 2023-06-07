package com.desafio.assertiva.service;

import com.desafio.assertiva.model.Client;
import com.desafio.assertiva.model.dto.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    Optional<ClientDTO> save(Client clientModel) throws Exception;

    List<Client> findByAreaCode(String areaCode) throws Exception;

    List<Client> findByName(String name) throws Exception;

    ClientDTO findById(int id);

    Optional<Client> update(int id, Client requestBody);

//    Page<ClientModel> list(Pageable page);
    List<Client> list();
}
