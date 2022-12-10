package com.example.users.service;

import com.example.users.model.Employee;
import com.example.users.model.User;

import java.util.List;

public interface EmployeeService {
    Employee getByID(Long personnel_number);

    void save(Employee employee);

    void deleteEmployee(Long personnel_number);

    List<Employee> getAll();
}
