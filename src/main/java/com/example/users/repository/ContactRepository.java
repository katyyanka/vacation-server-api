package com.example.users.repository;

import com.example.users.model.Contact;
import com.example.users.model.ContactId;
import com.example.users.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, ContactId> {
    @Query(
            value = "SELECT * FROM Contacts u WHERE u.personnel_number = ?1",
            nativeQuery = true)
    List<Contact> findByPersonnelNumber(Long personnel_number);
}
