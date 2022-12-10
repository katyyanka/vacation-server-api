package com.example.users.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table( name = "business_trip")
public class BusinessTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "personnel_number", nullable = false)
    private Employee employee;

    Date begin_date;

    Date end_date;

    String goal;

}
