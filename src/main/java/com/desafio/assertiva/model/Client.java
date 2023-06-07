package com.desafio.assertiva.model;

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
public class Client {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String name;
    @OneToMany(mappedBy="client", cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();
    @OneToMany(mappedBy="client", cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList<>();


}
