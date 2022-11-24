package com.code.muziki.userservice.domain;

import com.code.muziki.roleservice.domain.Role;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;
@Entity(name = "app_user")
public class AppUser {
    @Id @GeneratedValue(strategy = AUTO) @Column(name = "id")
    private Long id;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false)
    private String emailAddress;
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;
    @Column(name = "password",nullable = false)
    private String password;
    @OneToMany(fetch = EAGER)
    @Column(name = "roles")
    private List<Role> roles = new ArrayList<>();
}
