package com.example.users.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "positions")
@Getter
@Setter
@NoArgsConstructor
public class Position {
    @Id
    String position;

 //   @OneToMany(fetch = FetchType.EAGER, mappedBy = "position")
  //  transient private Set<Employee> employees;
}
