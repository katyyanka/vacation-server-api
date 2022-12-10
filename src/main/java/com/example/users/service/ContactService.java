package com.example.users.service;

import com.example.users.model.Contact;
import com.example.users.model.ContactId;
import com.example.users.model.Employee;

import java.util.List;

public interface ContactService {

    Contact getByID(ContactId contactId);

    void save(Contact contact);

    void deleteContact(ContactId contactId);

    List<Contact> getAll();

    List<Contact> getAllByPersonnelNumber(Long personnel_number);

}
