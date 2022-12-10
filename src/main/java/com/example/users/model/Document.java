package com.example.users.model;

import jakarta.persistence.*;

@Entity
@Table( name= "Documents")
public class Document {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "personnel_number", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "type_of_document", nullable = false)
    private TypeOfDocument typeOfDocument;

}
