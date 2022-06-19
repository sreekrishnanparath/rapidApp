package com.jst.rapidapp.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

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



    public User() {
    }

    public User(long userId, String userName, String lastName, int age, String userEmail, int userType, String password) {
        this.userId = userId;
        this.userName = userName;
        this.lastName = lastName;
        this.age = age;
        this.userEmail = userEmail;
        this.userType = userType;
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return null;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", userEmail='" + userEmail + '\'' +
                ", userType=" + userType +
                ", roles=" + roles +
                '}';
    }
}
