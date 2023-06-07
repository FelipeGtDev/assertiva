package com.desafio.assertiva.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "email")
public class Email {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    private String emailAddress;

    public Email(String email) {
        this.emailAddress = email;
    }

    public Email() {

    }
}
