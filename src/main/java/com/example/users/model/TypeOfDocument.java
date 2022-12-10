package com.example.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "types_of_contact")
@Getter
@Setter
@NoArgsConstructor
public class TypeOfDocument {
    @Id
    String type_of_document;
}
