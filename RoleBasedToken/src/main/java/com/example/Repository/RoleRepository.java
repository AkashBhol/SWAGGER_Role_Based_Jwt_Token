package com.example.Repository;

import com.example.MOdel.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    List<Role> findByRoleNameIn(List<String> names);

    public boolean existsByRoleName(String roleName);
}
