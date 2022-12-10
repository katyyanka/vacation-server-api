package com.example.users.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table (name = "roles")
@Getter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "role_id")
    private Long id;
    private String name;
 //   @ManyToMany(mappedBy = "roles")
 //   transient Collection<User> users;

    public void setId(Long id) {
        this.id = id;
    }
}
