package com.example.users.controller;

import com.example.users.model.Contact;
import com.example.users.model.Employee;
import com.example.users.model.EmployeeWithContacts;
import com.example.users.model.User;
import com.example.users.service.ContactService;
import com.example.users.service.EmployeeService;
import com.example.users.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {
    private final EmployeeService employeeService;
    private final ContactService contactService;

    public EmployeeRestController(EmployeeService employeeService, ContactService contactService) {
        this.employeeService = employeeService;
        this.contactService = contactService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long employeeID){
        if (employeeID == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Employee employee = this.employeeService.getByID(employeeID);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @RequestMapping(value="", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Validated Employee employee){
        HttpHeaders headers = new HttpHeaders();

        if (employee == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.employeeService.save(employee);
        return new ResponseEntity<>(employee,headers,HttpStatus.OK);
    }

    @RequestMapping(value="", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateUser(@RequestBody @Validated Employee employee){
        HttpHeaders headers = new HttpHeaders();

        if (employee == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.employeeService.save(employee);
        return new ResponseEntity<>(employee,headers,HttpStatus.OK);
    }

    @RequestMapping(value="{login}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable("login") Long personnel_number){
        if (this.employeeService.getByID(personnel_number) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.employeeService.deleteEmployee(personnel_number);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeWithContacts>> getAllEmployees(){
        List<EmployeeWithContacts> employees = new ArrayList<>();

        List<Employee> employees2 = this.employeeService.getAll();

        for (Employee employee: employees2 ) {
            employees.add(new EmployeeWithContacts(employee, this.contactService.getAllByPersonnelNumber(employee.getPersonnel_number())));
        }

        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

}
