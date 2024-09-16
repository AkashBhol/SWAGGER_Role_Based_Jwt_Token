package com.example.Controller;

import com.example.MOdel.Result;
import com.example.MOdel.Role;
import com.example.Service.RoleService;
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
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/create/role")
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        Result result = roleService.craeteRole(role);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/get/role")
    @PreAuthorize("hasRole('ROLE_SUPERADMIN')")
    public ResponseEntity<?> getRole() {
        List<Role> allRole = roleService.getAllRole();
        return new ResponseEntity<>(allRole, HttpStatus.OK);
    }
}
