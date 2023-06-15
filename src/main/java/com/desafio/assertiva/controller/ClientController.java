package com.desafio.assertiva.controller;

import com.desafio.assertiva.model.Client;
import com.desafio.assertiva.model.dto.ClientDTO;
import com.desafio.assertiva.model.dto.ClientSimplifiedDTO;
import com.desafio.assertiva.service.IClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @Autowired
    private IClientService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClientDTO clientDTO) {

        try {
            Optional<ClientDTO> clientOP = service.save(clientDTO);
            if(clientOP.isEmpty())
                return ResponseEntity.badRequest().build();
            log.info("Client saved: {}", clientOP.get().toString());
            return new ResponseEntity<>(clientOP.orElse(null), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // TODO melhorar tratamento de erro
        }
    }

    @GetMapping("/listByAreaCode/{areaCode}")
    public Page<ClientSimplifiedDTO> listClientByAreaCode(
            @PathVariable("areaCode") String areaCode,
            @PageableDefault(size = 15, page = 0, direction = Sort.Direction.DESC, sort = {"id"}) Pageable page
    ) throws Exception {
        return service.findByAreaCode(areaCode, page);
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
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ClientDTO request) {
        try {
            ClientDTO clientDTO = service.update(id, request);
            return new ResponseEntity<>(clientDTO, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build(); // TODO melhorar tratamento de erro
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try{
        service.deleteById(id);
        return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}