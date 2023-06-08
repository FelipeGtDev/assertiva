package com.desafio.assertiva.model.dto;

import com.desafio.assertiva.model.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PhoneDTO {
    private Integer id;
    private String ddd;
    private String number;

    public PhoneDTO(Phone phone) {
        this.id = phone.getId();
        this.ddd = phone.getDdd();
        this.number = phone.getNumber();
    }
}
