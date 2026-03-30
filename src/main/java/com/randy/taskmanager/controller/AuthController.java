package com.randy.taskmanager.controller;

import com.randy.taskmanager.dto.auth.AuthResponse;
import com.randy.taskmanager.dto.auth.LoginRequest;
import com.randy.taskmanager.dto.auth.RegisterRequest;
import com.randy.taskmanager.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}