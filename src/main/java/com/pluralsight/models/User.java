package com.pluralsight.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.pluralsight.models.Role.USER;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @NotBlank(message = "username is mandatory")
    private String  username;
    @Basic(optional = false)
    @Pattern(regexp = "^(.+)@(.+)$",message = "invamid email format")
    private String  email;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message = "Password must contain at least one digit [0-9].\n" +
            "Password must contain at least one lowercase Latin character [a-z].\n" +
            "Password must contain at least one uppercase Latin character [A-Z].\n" +
            "Password must contain at least one special character like ! @ # & ( ).\n" +
            "Password must contain a length of at least 8 characters and a maximum of 20 characters.")
    @Basic(optional = false)
    private String  password;

    @Lob
    @Column(name = "image",columnDefinition = "BLOB")
    private byte[] images;
    @Enumerated(STRING)
    private Role role = USER;

}
