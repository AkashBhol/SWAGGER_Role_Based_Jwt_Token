package com.example.Service;

import com.example.Configee.BsicUtil;
import com.example.MOdel.Result;
import com.example.MOdel.Role;
import com.example.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends BsicUtil implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Result craeteRole(Role role) {
        if(roleRepository.existsByRoleName(role.getRoleName().toLowerCase())){
            return prepareResponseObject("333","Role name allredy exist","");
        }
        Role save = roleRepository.save(role);
        return prepareResponseObject("222","Role creaated successfully","");

    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
