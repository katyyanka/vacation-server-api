package com.example.users.service;

import com.example.users.model.Contact;
import com.example.users.model.ContactId;
import com.example.users.model.Employee;
import com.example.users.repository.ContactRepository;
import com.example.users.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact getByID(ContactId contactId) {
        return contactRepository.findById(contactId).get();
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(ContactId contactId) {
        contactRepository.deleteById(contactId);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> getAllByPersonnelNumber(Long personnel_number) {
        return contactRepository.findByPersonnelNumber(personnel_number);
    }
}
