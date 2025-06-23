package com.example.schoolManagementSystem.dtos.User;

import com.example.schoolManagementSystem.enums.Role;
import jakarta.validation.constraints.NotNull;

public class UserUpdateRequestDto {
    @NotNull
    private String email;

    @NotNull
    private Role role;

    public UserUpdateRequestDto() {
    }

    public UserUpdateRequestDto(String email, Role role) {
        this.email = email;
        this.role = role;
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
