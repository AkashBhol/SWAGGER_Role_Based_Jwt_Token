package com.example.MOdel;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String roleName;


}
