package com.jhonproy.jhonproy.web.rest.request;

import com.jhonproy.jhonproy.dto.UserAccountDTO;
import com.jhonproy.jhonproy.dto.UserDetailDTO;
import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserCreationRequest {
    /*private UserAccountDTO userAccount;
    private UserDetailDTO userDetail;

    public UserAccountDTO getUserAccount() {
        return userAccount;
    }

    public UserDetailDTO getUserDetail() {
        return userDetail;
    }

    public void setUserAccount(UserAccountDTO userAccount) {
        this.userAccount = userAccount;
    }

    public void setUserDetail(UserDetailDTO userDetail) {
        this.userDetail = userDetail;
    }*/

    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    //Detalles
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDay;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public UserAccountDTO getUserAccount() {

        UserAccountDTO userAccountDTO = new UserAccountDTO();
        userAccountDTO.setCreatedAt(createdAt);
        userAccountDTO.setPassword(password);
        userAccountDTO.setEmail(email);
        userAccountDTO.setUsername(username);
        userAccountDTO.setPassword(password);

        return userAccountDTO;
    }

    public UserDetailDTO getUserDetail() {

        UserDetailDTO userDetailDTO = new UserDetailDTO();

        userDetailDTO.setUserId(id);
        userDetailDTO.setAge(age);
        userDetailDTO.setBirthDay(birthDay);
        userDetailDTO.setFirstName(firstName);
        userDetailDTO.setLastName(lastName);

        return userDetailDTO;
    }
}
