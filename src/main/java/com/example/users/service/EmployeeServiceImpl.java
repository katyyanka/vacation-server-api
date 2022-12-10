package com.example.users.service;

import com.example.users.model.Employee;
import com.example.users.model.User;
import com.example.users.repository.EmployeeRepository;
import com.example.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getByID(Long personnel_number) {
        return employeeRepository.findById(personnel_number).get();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long personnel_number) {
        employeeRepository.deleteById(personnel_number);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
