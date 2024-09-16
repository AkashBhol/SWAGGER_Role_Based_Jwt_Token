package com.example.Service;

import com.example.MOdel.Result;
import com.example.MOdel.Role;

import java.util.List;

public interface RoleService {

    public Result craeteRole(Role role);

    public List<Role> getAllRole();
}
