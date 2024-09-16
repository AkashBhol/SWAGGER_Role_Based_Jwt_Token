package com.example.Controller;

import com.example.MOdel.Result;
import com.example.MOdel.User;
import com.example.MOdel.UserDTO;
import com.example.Service.UesrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UesrService uesrService;

    @PostMapping("/create/user")
    public ResponseEntity<Result> craeteUser(@RequestBody UserDTO user){
        Result user1 = uesrService.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/get/user")
    public ResponseEntity<?> getAllUser(){
        List<User> aLlUser = uesrService.getALlUser();
        return new ResponseEntity<>(aLlUser, HttpStatus.OK);
    }
}
