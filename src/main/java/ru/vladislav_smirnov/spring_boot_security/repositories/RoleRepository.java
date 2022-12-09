package ru.vladislav_smirnov.spring_boot_security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vladislav_smirnov.spring_boot_security.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
