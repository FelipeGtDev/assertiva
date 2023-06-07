package com.desafio.assertiva.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
//@Builder
public class EmailDTO {
    private Integer id;
    private String email;
}
