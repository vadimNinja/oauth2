package com.bob.oauth2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private Long salary;
    @Column
    private int age;

}
