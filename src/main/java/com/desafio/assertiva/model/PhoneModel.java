package com.desafio.assertiva.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "phone")
public class PhoneModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;
    private String ddd;
    private String number;


    public PhoneModel(String fullNumber) {
        if (fullNumber.substring(0,1) == "0"){
            this.ddd = fullNumber.substring(1, 3);
            this.number = fullNumber.substring(3);
        } else {
            this.ddd = fullNumber.substring(0, 2);
            this.number = fullNumber.substring(2);
        }
    }

    public PhoneModel(String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
    }

    public PhoneModel() {

    }
}
