package com.example.schoolManagementSystem.controllers;

import com.example.schoolManagementSystem.dtos.Authentication.AuthenticationRequestDto;
import com.example.schoolManagementSystem.dtos.Authentication.AuthenticationResponse;
import com.example.schoolManagementSystem.dtos.Authentication.RegisterRequestDto;
import com.example.schoolManagementSystem.entities.User;
import com.example.schoolManagementSystem.services.AuthenticationService;
import com.example.schoolManagementSystem.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public AuthController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequestDto authRequest) {
        String jwt = authenticationService.authenticate(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequestDto request) {
        User createdUser = userService.registerUser(request);
        return ResponseEntity.ok("User registered successfully: " + createdUser.getUsername());
    }
}