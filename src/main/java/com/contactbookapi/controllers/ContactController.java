package com.contactbookapi.controllers;

import com.contactbookapi.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public ResponseEntity getAllContacts(){
        return contactService.listContacts();
    }

    @PostMapping("/contact/new")
    public void newContact(@RequestParam("phone") String phone,
                           @RequestParam("name") String name,
                           @RequestParam(value = "surname", required = false) String surname){

    }

    @DeleteMapping("/contact/delete")
    public void deleteContacts(){

    }

    @GetMapping("/contact/{name}/get")
    public void getContact(@PathVariable("name") String name){

    }

    @DeleteMapping("/contact/{name}/delete")
    public void deleteContact(@PathVariable("name") String name){

    }

    @PutMapping("/contact/{name}/update")
    public void updateContact(@PathVariable("name") String oldName,
                              @RequestParam("phone") String phone,
                              @RequestParam("name") String newName,
                              @RequestParam(value = "surname", required = false) String surname){

    }
}