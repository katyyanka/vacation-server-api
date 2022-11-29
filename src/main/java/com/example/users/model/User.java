package com.example.users.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table (name = "users")
@Getter
@Setter
@ToString
public class User  implements Serializable {
    @Id
    private Long personnel_number;
    private String username;
    private String password;
    private boolean enabled;
}
