package com.desafio.assertiva.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClientDTO {

    private Integer id;
    private String cpf;
    private String name;
    private List<PhoneDTO> phones = new ArrayList<>();
    private List<EmailDTO> emails = new ArrayList<>();

}
