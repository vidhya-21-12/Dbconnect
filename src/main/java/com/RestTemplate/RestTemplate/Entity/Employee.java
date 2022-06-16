package com.RestTemplate.RestTemplate.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "dept")
    private String dept;

    @Column(name = "ecperience")
    private String experience;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "password")
    private String password;
}

