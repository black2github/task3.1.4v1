package ru.kata.spring.boot_security.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "roles")
// @Data
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(unique = true)
    private String name;

    public Role() {}

    public Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Role{id=%d, name='%s'}", id, name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (o.getClass() != Role.class)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        return (getName().equals(((Role) o).getName()));
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
