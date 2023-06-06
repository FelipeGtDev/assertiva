package com.desafio.assertiva.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhoneDTO {
    private Integer id;
    private String ddd;
    private String number;


}
