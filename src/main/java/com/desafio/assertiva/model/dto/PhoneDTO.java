package com.desafio.assertiva.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
//@Builder
public class PhoneDTO {
    private Integer id;
    private String ddd;
    private String number;


}
