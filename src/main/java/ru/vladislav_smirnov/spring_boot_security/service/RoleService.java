package ru.vladislav_smirnov.spring_boot_security.service;

import ru.vladislav_smirnov.spring_boot_security.model.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> getAllRoles();
}
