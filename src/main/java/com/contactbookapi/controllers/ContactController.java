package com.contactbookapi.controllers;

import com.contactbookapi.models.Contact;
import com.contactbookapi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    public HashMap<String, Integer> newContact(@RequestParam("phone") String phone,
                                                   @RequestParam("name") String name,
                                                   @RequestParam(value = "surname", required = false) String surname){
        contactService.addContact(new Contact(phone, name, surname));
        return contactService.responceOK();
    }

    @DeleteMapping("/contact/delete")
    @ResponseBody
    public HashMap<String, Integer> deleteContacts(){
        contactService.deleteAllContacts();
        return contactService.responceOK();
    }

    @GetMapping("/contact/{name}/get")
    public ResponseEntity<Contact> getContact(@PathVariable("name") String name){
        return contactService.getContact(contactService.findByName(name));
    }

    @DeleteMapping("/contact/{name}/delete")
    @ResponseBody
    public HashMap<String, Integer> deleteContact(@PathVariable("name") String name){
        contactService.deleteByName(name);
        return contactService.responceOK();
    }

    @PutMapping("/contact/{name}/update")
    @ResponseBody
    public HashMap<String, Integer> updateContact(@PathVariable("name") String oldName,
                                                  @RequestParam("phone") String phone,
                                                  @RequestParam("newname") String newName,
                                                  @RequestParam(value = "surname", required = false) String surname){
        contactService.updateContact(oldName, new Contact(phone, newName, surname));
        return contactService.responceOK();
    }
}