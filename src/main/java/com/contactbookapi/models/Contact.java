package com.contactbookapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ContactBook")
@Data
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phone;

    private String name;

    private String surname = null;

    public Contact(String phone, String name, String surname) {
        this.phone = phone;
        this.name = name;
        this.surname = surname;
    }
}
