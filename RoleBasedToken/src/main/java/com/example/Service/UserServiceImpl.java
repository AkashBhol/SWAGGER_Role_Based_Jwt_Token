package com.example.Service;

import com.example.Configee.BsicUtil;
import com.example.MOdel.Result;
import com.example.MOdel.Role;
import com.example.MOdel.User;
import com.example.MOdel.UserDTO;
import com.example.Repository.RoleRepository;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BsicUtil implements UesrService   {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Result createUser(UserDTO payload) {

        boolean p= userRepository.existsByEmail(payload.getEmail());
        if(p){
          return prepareResponseObject("003","Email is allready exist","");
        }
        List<Role> roles = roleRepository.findByRoleNameIn(payload.getRoles());

        User user = new User();
        user.setRoles(roles);
        user.setName(payload.getName());
        user.setEmail(payload.getEmail());
        user.setPassword(passwordEncoder.encode(payload.getPassword()));
        User save = userRepository.save(user);
        return prepareResponseObject("","user Created successfully","");
    }

    @Override
    @PreAuthorize("hasRole('ROLE_HQ') or hasRole('ROLE_ADMIN')")
    public List<User> getALlUser() {
        return userRepository.findAll();
    }
}
