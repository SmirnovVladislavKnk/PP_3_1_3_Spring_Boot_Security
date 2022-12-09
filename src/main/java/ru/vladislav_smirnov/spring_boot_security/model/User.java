package ru.vladislav_smirnov.spring_boot_security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)

    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "age")
    private byte age;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roleSet;

    public User() {
    }

    public User(String name, String surname, byte age, String email, String password, Collection<Role> roleSet) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roleSet = roleSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Collection<Role> roleSet) {
        this.roleSet = roleSet;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleSet.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getAge() == user.getAge() && getId().equals(user.getId()) && getName().equals(user.getName()) && getSurname().equals(user.getSurname()) && getEmail().equals(user.getEmail()) && getPassword().equals(user.getPassword()) && getRoleSet().equals(user.getRoleSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getAge(), getEmail(), getPassword(), getRoleSet());
    }

    @Override
    public String toString() {
        return this.roleSet.stream()
                .map(Role::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
