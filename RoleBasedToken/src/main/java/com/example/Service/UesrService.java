package com.example.Service;

import com.example.MOdel.Result;
import com.example.MOdel.User;
import com.example.MOdel.UserDTO;

import java.util.List;

public interface UesrService {

    public Result createUser(UserDTO user);

    public List<User> getALlUser();
}
