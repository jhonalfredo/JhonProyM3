package com.jhonproy.jhonproy.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre del rol no puede estar en blanco")
    @Size(min = 3, message = "El nombre del rol debe tener al menos 3 caracteres")
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    public List<UserRol> getUserRols() {
        return userRols;
    }

    public void setUserRols(List<UserRol> userRols) {
        this.userRols = userRols;
    }
     */

    //@OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<UserRol> userRols;

    // Getters and setters
}
