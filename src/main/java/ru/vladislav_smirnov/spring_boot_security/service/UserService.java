package ru.vladislav_smirnov.spring_boot_security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.vladislav_smirnov.spring_boot_security.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    void saveUsers(User user);

    User getUserById(Long id);

    void deleteUserById(Long id);

    User findByEmail(String email);
}
