package com.desafio.assertiva.service.implementations;

import com.desafio.assertiva.model.Email;
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

    public List<Email> findByClientId(int client_id) {
        return repository.findByClientId(client_id);
    }

     public List<EmailDTO> feelContactItems(int clientId){
        List<Email> email = findByClientId(clientId);
        List<EmailDTO> emailDTO = new ArrayList<>();
        for (Email phone : email) {
            emailDTO.add(new EmailDTO(phone.getId(), phone.getEmail()));
        }
        return emailDTO;
    }

}
