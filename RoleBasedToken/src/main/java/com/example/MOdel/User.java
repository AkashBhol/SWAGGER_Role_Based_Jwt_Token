package com.example.MOdel;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private String password;

    private String name;

    private String about;

    @ManyToMany
    private List<Role> roles;
}
