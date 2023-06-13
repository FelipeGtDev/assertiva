package com.desafio.assertiva.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientDTO {

    private Integer id;
    private String cpf;
    private String name;
    private List<PhoneDTO> phones = new ArrayList<>();
    private List<EmailDTO> emails = new ArrayList<>();



}
