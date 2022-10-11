package com.contactbookapi.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ContactBook")
@Data
public class Contact {
    @Id
    private Long id;

    private String phone;

    private String name;

    private String surname;
}
