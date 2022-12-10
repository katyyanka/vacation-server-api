package com.example.users.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ContactId implements Serializable {
    public Long personnel_number;
    public String type_of_contact;
}
