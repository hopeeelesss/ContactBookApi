package com.contactbookapi.controllers;

import com.contactbookapi.models.Contact;
import com.contactbookapi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    @ResponseBody
    public List<Contact> getAllContacts(){
        return contactService.listContacts();
    }

    @PostMapping("/contact/new")
    public void newContact(@RequestParam("phone") String phone,
                           @RequestParam("name") String name,
                           @RequestParam(value = "surname", required = false) String surname){
        contactService.addContact(new Contact(phone, name, surname));
    }

    @DeleteMapping("/contact/delete")
    public void deleteContacts(){
        contactService.deleteAllContacts();
    }

    @GetMapping("/contact/{name}/get")
    public ResponseEntity<Contact> getContact(@PathVariable("name") String name){
        return contactService.getContact(contactService.findByName(name));
    }

    @DeleteMapping("/contact/{name}/delete")
    public void deleteContact(@PathVariable("name") String name){
        contactService.deleteByName(name);
    }

    @PutMapping("/contact/{name}/update")
    public void updateContact(@PathVariable("name") String oldName,
                              @RequestParam("phone") String phone,
                              @RequestParam("newname") String newName,
                              @RequestParam(value = "surname", required = false) String surname){
        contactService.updateContact(oldName, new Contact(phone, newName, surname));
    }
}