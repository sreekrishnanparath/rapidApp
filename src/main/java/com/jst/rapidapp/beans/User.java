package com.jst.rapidapp.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long userId;
    @NotEmpty(message = "User Name is required")
    private String userName;

    private String lastName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty (message = "Email is required")
    private String password;

    @NotNull(message = "Age is required")
    @Min(value = 1,message= "Age should not be 0 or negative")
    @Max(value = 100,message = "Age should not be greater than 100")
    private int age;

    @NotEmpty (message = "Email is required")
    @Email(message = "Email format is incorrect")
    private String userEmail;

    //0-individual 1-cooperate

    private int userType;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();




}
