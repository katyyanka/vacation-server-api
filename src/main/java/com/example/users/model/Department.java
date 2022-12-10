package com.example.users.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Departments")
@Getter
@Setter
@NoArgsConstructor
public class Department {
    @Id
    String department;

   @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
   @JoinColumn(name = "address_id", nullable = false)
   private Address address;

   Long manager_id;




}
