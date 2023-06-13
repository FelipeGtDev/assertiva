package com.desafio.assertiva.model;

import com.desafio.assertiva.model.dto.EmailDTO;
import com.desafio.assertiva.model.dto.PhoneDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client implements Serializable {


    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "client_seq", allocationSize = 1)
    private Integer id;

    private String cpf;

    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @OrderBy("ddd ASC")
    private List<Phone> phones = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @OrderBy("email ASC")
    private List<Email> emails = new ArrayList<>();

    public void setRelationsClientContacts() {
        this.getPhones().stream().forEach(phone -> phone.setClient(this));
        this.getEmails().stream().forEach(email -> email.setClient(this));
    }


    public List<PhoneDTO> convertPhoneToDTO() {
        List<PhoneDTO> phonesDTO = new ArrayList<>();
        for (Phone phone : this.phones) {
            phonesDTO.add(new PhoneDTO(phone));
        }

        return phonesDTO;
    }

    public List<EmailDTO> convertEmailToDTO() {
        List<EmailDTO> emailsDTO = new ArrayList<>();
        for (Email email : this.emails) {
            emailsDTO.add(new EmailDTO(email));
        }

        return emailsDTO;

    }
}