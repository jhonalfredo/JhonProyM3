package com.jhonproy.jhonproy.dto;
import java.time.LocalDateTime;

// src/main/java/com/diplomado/courses/dto/UserAccountDTO.java
public class UserAccountDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    //private UserDetailDTO userDetail; // DTO para almacenar detalles del usuario
    // getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
/*
    public UserDetailDTO getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailDTO userDetail) {
        this.userDetail = userDetail;
    }

 */
}