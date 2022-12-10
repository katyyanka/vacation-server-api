package com.example.users.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.SQLData;
import java.util.Set;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long personnel_number;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "department", nullable = false)
    Department department;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "position", nullable = false)
    Position position;

    Date employment_date;

    Date termination_date;

    String lastname;

    String firstname;

    String patronymic;

    String gender;

    String citizenship;

    Date birth_date;

    Float average_salary;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personnel_number")
    private User user;
}
