package com.desafio.assertiva.controller;

import com.desafio.assertiva.model.ClientModel;
import com.desafio.assertiva.model.dto.ClientDTO;
import com.desafio.assertiva.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IClientService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClientModel requestBody) {
        try{
            Optional<ClientDTO> clientOP =  service.save(requestBody);
            return new ResponseEntity<>(clientOP.get(), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // TODO melhorar tratamento de erro
        }
    }

    @GetMapping("/phone/{areaCode}")
    public List<ClientModel> listClientByAreaCode(@PathVariable("areaCode") String areaCode) {
        try{
            return service.findByAreaCode(areaCode);
        } catch (Exception e) {
            return null; // TODO melhorar tratamento de erro
        }
    }

    @GetMapping
    public ResponseEntity<List<ClientModel>> findByName(@RequestParam("name") String name) {
        try{
            List<ClientModel> clients = service.findByName(name);
            ResponseEntity<List<ClientModel>> clientModelResponseEntity = new ResponseEntity<>(clients, HttpStatus.OK);
            return clientModelResponseEntity;
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // TODO melhorar tratamento de erro
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable("id") int id) {
        try{
            Optional<ClientDTO> client = Optional.ofNullable(service.findById(id));

            ResponseEntity<ClientDTO> clientModelResponseEntity = new ResponseEntity<>(client.get(), HttpStatus.OK);
            return clientModelResponseEntity;
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // TODO melhorar tratamento de erro
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ClientModel requestBody) {
        try{
            Optional<ClientModel> clientOP =  service.update(id, requestBody);
            return new ResponseEntity<>(clientOP.get(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // TODO melhorar tratamento de erro
        }
    }
}
