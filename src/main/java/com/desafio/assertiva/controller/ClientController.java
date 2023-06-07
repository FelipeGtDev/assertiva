package com.desafio.assertiva.controller;

import com.desafio.assertiva.model.Client;
import com.desafio.assertiva.model.dto.ClientDTO;
import com.desafio.assertiva.model.dto.ClientSimplifiedDTO;
import com.desafio.assertiva.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<?> save(@RequestBody Client requestBody) {
        try {
            Optional<ClientDTO> clientOP = service.save(requestBody);
            return new ResponseEntity<>(clientOP.orElse(null), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // TODO melhorar tratamento de erro
        }
    }

    @GetMapping("/phone/{areaCode}")
    public List<Client> listClientByAreaCode(@PathVariable("areaCode") String areaCode) {
        try {
            return service.findByAreaCode(areaCode);
        } catch (Exception e) {
            return null; // TODO melhorar tratamento de erro
        }
    }

    @GetMapping
    public Page<ClientSimplifiedDTO> findByName(
            @RequestParam("name") String name,
            @PageableDefault(size = 15, page = 0, direction = Sort.Direction.DESC, sort = {"id"}) Pageable page
    ) throws Exception {
        return service.findByName(name, page);
    }

    @GetMapping("/listAll")
    public Page<ClientSimplifiedDTO> list(
            @PageableDefault(size = 15, page = 0, direction = Sort.Direction.DESC, sort = {"id"}) Pageable page) {

        return service.list(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable("id") int id) {
        try {
            Optional<ClientDTO> client = Optional.ofNullable(service.findById(id));

            return new ResponseEntity<>(client.orElse(null), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // TODO melhorar tratamento de erro
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Client requestBody) {
        try {
            Optional<Client> clientOP = service.update(id, requestBody);
            return new ResponseEntity<>(clientOP.orElse(null), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // TODO melhorar tratamento de erro
        }
    }
}
