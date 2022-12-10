package com.example.users.controller;


import com.example.users.model.Contact;
import com.example.users.model.Employee;
import com.example.users.service.ContactService;
import com.example.users.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/contacts")
public class ContactRestController {
    private final ContactService contactService;

    public ContactRestController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>> getContactsByEmployee(@PathVariable("id") Long employeeID){
        if (employeeID == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Contact> contacts = this.contactService.getAllByPersonnelNumber(employeeID);
        if (contacts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
}
