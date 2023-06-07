package com.desafio.assertiva.service;

import com.desafio.assertiva.model.Phone;
import com.desafio.assertiva.model.dto.PhoneDTO;

import java.util.List;

public interface IPhoneService {

    List<Phone> findByClientId(Integer client_id);

    List<PhoneDTO> feelContactItems(int clientId);
}
