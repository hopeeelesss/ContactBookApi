package com.contactbookapi.repos;

import com.contactbookapi.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findContactById(Long Id);

    Contact findContactByName(String name);

    void deleteByName(String name);
}
