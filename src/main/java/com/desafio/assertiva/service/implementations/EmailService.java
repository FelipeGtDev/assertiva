package com.desafio.assertiva.service.implementations;

import com.desafio.assertiva.model.EmailModel;
import com.desafio.assertiva.model.dto.EmailDTO;
import com.desafio.assertiva.repository.EmailRepository;
import com.desafio.assertiva.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Autowired
    public EmailRepository repository;

    public List<EmailModel> findByClientId(int client_id) {
        List<EmailModel> emails = repository.findByClientId(client_id);
        return emails;
    }

     public List<EmailDTO> feelContactItems(int clientId){
        List<EmailModel> email = findByClientId(clientId);
        List<EmailDTO> emailDTO = new ArrayList<>();
        for (EmailModel phone : email) {
            emailDTO.add(new EmailDTO(phone.getId(), phone.getEmail()));
        }
        return emailDTO;
    }

}
