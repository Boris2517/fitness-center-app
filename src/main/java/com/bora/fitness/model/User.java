package com.bora.fitness.model;




import javax.persistence.*;
import java.util.Date;
@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="email")
    private String email;
    private Date birthDate;
    private String role;
    @Column(name="status")
    private Boolean status;

    public User() {
    }

    public User(Long id, String username, String password, String firstName, String lastName, String phoneNumber, String email, Date birthDate, String role, Boolean status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
        this.role = role;
        this.status = status;
    }
}
