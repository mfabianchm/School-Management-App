package com.example.schoolManagementSystem.dtos.User;

import com.example.schoolManagementSystem.enums.Role;

public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private Role role;

    public UserResponseDto() {
    }

    public UserResponseDto(Long id, String username, Role role, String email) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
