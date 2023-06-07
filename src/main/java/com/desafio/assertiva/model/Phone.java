package com.desafio.assertiva.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "phone")
public class Phone {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    private String ddd;
    private String number;


    public Phone(String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
    }

    public Phone() {

    }
}
