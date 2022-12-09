package ru.vladislav_smirnov.spring_boot_security.InitDefaultUsersWithRoles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vladislav_smirnov.spring_boot_security.model.Role;
import ru.vladislav_smirnov.spring_boot_security.model.User;
import ru.vladislav_smirnov.spring_boot_security.service.RoleService;
import ru.vladislav_smirnov.spring_boot_security.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;

@Component
public class InitDefaultUsersWithRoles {

    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public InitDefaultUsersWithRoles(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUsersWithRoles() {
        if(roleService.getAllRoles().isEmpty()) {
            Role role_admin = new Role("ROLE_ADMIN");
            Collection<Role> role_ad = new HashSet<>();
            role_ad.add(role_admin);
            User admin= new User();
            admin.setName("admin");
            admin.setSurname("admin");
            admin.setAge((byte) 23);
            admin.setEmail("admin@mail.ru");
            admin.setPassword("admin");
            admin.setRoleSet(role_ad);
            userService.saveUsers(admin); // Login: admin@mail.ru; Password: admin.

            Role role_user = new Role("ROLE_USER");
            Collection<Role> role_us = new HashSet<>();
            role_us.add(role_user);
            User user = new User();
            user.setName("user");
            user.setSurname("user");
            user.setAge((byte) 23);
            user.setEmail("user@mail.ru");
            user.setPassword("user");
            user.setRoleSet(role_us);
            userService.saveUsers(user); // Login: user@mail.ru; Password: user.

        }
    }
}
