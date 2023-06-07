package com.desafio.assertiva.service.implementations;

import com.desafio.assertiva.model.Phone;
import com.desafio.assertiva.model.dto.PhoneDTO;
import com.desafio.assertiva.repository.PhoneRepository;
import com.desafio.assertiva.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneService implements IPhoneService{

    @Autowired
    public PhoneRepository repository;

    public List<Phone> findByClientId(Integer client_id){
        return repository.findByClientId(client_id);
    }

    public List<PhoneDTO> feelContactItems(int clientId){
        List<Phone> phones = findByClientId(clientId);
        List<PhoneDTO> phonesDTO = new ArrayList<>();
        for (Phone phone : phones) {
            phonesDTO.add(new PhoneDTO(phone.getId(), phone.getDdd(), phone.getNumber()));
        }
        return phonesDTO;
    }

}
