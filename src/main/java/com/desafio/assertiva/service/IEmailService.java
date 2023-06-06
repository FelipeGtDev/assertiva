package com.desafio.assertiva.service;

import com.desafio.assertiva.model.EmailModel;
import com.desafio.assertiva.model.dto.EmailDTO;

import java.util.List;

public interface IEmailService {

    List<EmailModel> findByClientId(int client_id);

    List<EmailDTO> feelContactItems(int clientId);
}
