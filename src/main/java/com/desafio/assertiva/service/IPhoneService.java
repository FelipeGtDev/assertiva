package com.desafio.assertiva.service;

import com.desafio.assertiva.model.PhoneModel;
import com.desafio.assertiva.model.dto.PhoneDTO;

import java.util.List;

public interface IPhoneService {

    List<PhoneModel> findByClientId(Integer client_id);

    List<PhoneDTO> feelContactItems(int clientId);
}
