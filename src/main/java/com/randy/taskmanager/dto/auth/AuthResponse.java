package com.randy.taskmanager.dto.auth;

import lombok.*;

@Getter
@Setter

public class AuthResponse {

    private String message;

    public AuthResponse() {
    }

    public AuthResponse(String message) {
        this.message = message;
    }
}