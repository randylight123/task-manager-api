package com.randy.taskmanager.dto.auth;

import lombok.*;

@Getter
@Setter

public class AuthResponse {

    private String token;
    private String message;

    public AuthResponse() {
    }

    public AuthResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }
}