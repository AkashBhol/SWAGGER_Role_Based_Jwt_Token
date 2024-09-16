package com.example.MOdel;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String email;

    private String password;

    private String name;

    private String about;

    private List<String> roles;
}
