package com.desafio.assertiva.model.dto;

import com.desafio.assertiva.model.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class EmailDTO {
    private Integer id;
    private String email;

    public EmailDTO(Email email) {
        this.id = email.getId();
        this.email = email.getEmail();
    }
}
