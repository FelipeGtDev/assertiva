package com.desafio.assertiva.service;

import com.desafio.assertiva.model.ClientModel;
import com.desafio.assertiva.model.dto.ClientDTO;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    Optional<ClientDTO> save(ClientModel clientModel) throws Exception;

    List<ClientModel> findByAreaCode(String areaCode) throws Exception;

    List<ClientModel> findByName(String name) throws Exception;

    ClientDTO findById(int id);

    Optional<ClientModel> update(int id, ClientModel requestBody);
}
