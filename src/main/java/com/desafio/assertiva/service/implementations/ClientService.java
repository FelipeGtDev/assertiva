package com.desafio.assertiva.service.implementations;

import com.desafio.assertiva.model.Client;
import com.desafio.assertiva.model.dto.ClientDTO;
import com.desafio.assertiva.repository.ClientRepository;
import com.desafio.assertiva.service.IClientService;
import com.desafio.assertiva.service.IEmailService;
import com.desafio.assertiva.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    @Autowired
    public ClientRepository repository;

    @Autowired
    public IPhoneService phoneService;

    @Autowired
    public IEmailService emailService;


    @Override
    public Optional<ClientDTO> save(Client clientModel) {

        Optional<Client> clientOP = Optional.of(repository.save(clientModel));

        return Optional.ofNullable(feelClient(clientOP.get()));
    }

    @Override
    public List<Client> findByAreaCode(String areaCode) {
        return repository.findClientByAreaCode(areaCode);
    }

    @Override
    public List<Client> findByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

    @Override
    public ClientDTO findById(int id) {

        Client client = repository.findById(id);

        return feelClient(client);
    }


    public ClientDTO feelClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setCpf(client.getCpf());
        clientDTO.setName(client.getName());

        int clientId = client.getId();

        // TODO Tentar melhorar isso usando interface . Usar o Objeto ClientDTO no lugar de clintId nos parametros de entrada.
        clientDTO.setPhones(phoneService.feelContactItems(clientId));
        clientDTO.setEmails(emailService.feelContactItems(clientId));


        return clientDTO;
    }

    @Override
    public Optional<Client> update(int id, Client requestBody) {

        Client client = repository.findById(id);

        if (client != null) {
            client.setName(requestBody.getName());
            client.setCpf(requestBody.getCpf());
            client.setPhones(requestBody.getPhones());
            client.setEmails(requestBody.getEmails());
            return Optional.of(repository.save(client));
        }
        throw new RuntimeException("Cliente não encontrado");
    }

//    @Override
//    public Page<ClientModel> list(Pageable page) {
//        return repository.findAllWithPagination(page);
//    }

    @Override
    public List<Client> list() {
        return repository.findAll();
    }
}
