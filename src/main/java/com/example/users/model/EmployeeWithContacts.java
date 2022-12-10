package com.example.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EmployeeWithContacts {
    Employee employee;
    List<Contact> contacts;
}
