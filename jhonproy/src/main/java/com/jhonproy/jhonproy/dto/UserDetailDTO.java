package com.jhonproy.jhonproy.dto;

import com.jhonproy.jhonproy.domain.entities.UserAccount;

import java.time.LocalDate;

public class UserDetailDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDay;
    // getters y setters

    private UserAccountDTO account;

    public void setAccount(UserAccountDTO account) {
        this.account = account;
    }

    public UserAccountDTO getAccount() {
        return account;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
