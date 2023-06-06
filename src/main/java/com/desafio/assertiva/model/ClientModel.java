package com.desafio.assertiva.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class ClientModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PhoneModel> phones = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private List<EmailModel> emails = new ArrayList<>();

    public ClientModel(ClientModel clientModel){

    }


}
