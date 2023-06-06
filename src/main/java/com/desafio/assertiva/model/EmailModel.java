package com.desafio.assertiva.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "email")
public class EmailModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;
    private String email;

    public EmailModel(String email) {
        this.email = email;
    }

    public EmailModel() {

    }
}
