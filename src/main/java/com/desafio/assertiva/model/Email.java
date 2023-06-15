package com.desafio.assertiva.model;

import com.desafio.assertiva.model.dto.EmailDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "email")
public class Email implements Serializable {



    @Id
    @Column(name = "email_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_seq")
    @SequenceGenerator(name = "email_seq", sequenceName = "email_seq", allocationSize = 1)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public Email() {

    }

    public Email(EmailDTO emailDTO) {
        this.email = emailDTO.getEmail();
    }
}