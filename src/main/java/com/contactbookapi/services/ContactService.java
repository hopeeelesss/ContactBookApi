package com.contactbookapi.services;

import com.contactbookapi.models.Contact;
import com.contactbookapi.repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> listContacts(){
//        Map<Long, List<Contact>> data = contactRepository.findAll().stream()
//                .collect(Collectors.groupingBy(Contact::getId));
//        MultiValueMap<Long, Contact> list = new LinkedMultiValueMap<>(data);
//        return new ResponseEntity(list, HttpStatus.OK);
        return contactRepository.findAll();
    }

    public void addContact(Contact contact){
        contactRepository.save(contact);
    }

    public void deleteAllContacts(){contactRepository.deleteAll();}

    public ResponseEntity<Contact> getContact(Contact contact){
        return new ResponseEntity<Contact>(
                contactRepository.findContactById(contact.getId()),
                HttpStatus.OK);
    }

    public Contact findByName(String name){return contactRepository.findContactByName(name);}

    public void deleteByName(String name){contactRepository.deleteByName(name);}

    public void updateContact(String oldName, Contact contact){
        contactRepository.deleteByName(oldName);
        contactRepository.save(contact);
    }
}
