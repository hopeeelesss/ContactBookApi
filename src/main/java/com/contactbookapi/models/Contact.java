package com.contactbookapi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ContactBook")
@Data
@NoArgsConstructor
public class Contact {
    @Id
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
