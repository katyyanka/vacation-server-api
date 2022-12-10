package com.example.users.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table (name = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable {
    @Id
    private Long personnel_number;
    private String username;
    private String password;
    private boolean enabled;
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "personnel_number"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id"))
    private  Collection<Role> roles;


}
