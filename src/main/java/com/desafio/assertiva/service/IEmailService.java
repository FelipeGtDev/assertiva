package com.desafio.assertiva.service;

import com.desafio.assertiva.model.Email;
import com.desafio.assertiva.model.dto.EmailDTO;

import java.util.List;

public interface IEmailService {

    List<Email> findByClientId(int client_id);

    List<EmailDTO> feelContactItems(int clientId);
}
