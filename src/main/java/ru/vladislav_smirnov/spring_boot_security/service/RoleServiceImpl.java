package ru.vladislav_smirnov.spring_boot_security.service;

import org.springframework.stereotype.Repository;
import ru.vladislav_smirnov.spring_boot_security.model.Role;
import ru.vladislav_smirnov.spring_boot_security.repositories.RoleRepository;

import java.util.Collection;

@Repository
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Collection<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
