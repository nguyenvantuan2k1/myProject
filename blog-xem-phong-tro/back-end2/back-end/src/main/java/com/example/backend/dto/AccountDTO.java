package com.example.backend.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class AccountDTO {
    @Column(unique = true)
    private String username;

    private String password;

    private String email;
    // gender, phone, sdt

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
}
