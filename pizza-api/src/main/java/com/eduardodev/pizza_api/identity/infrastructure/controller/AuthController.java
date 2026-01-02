package com.eduardodev.pizza_api.identity.infrastructure.controller;

import com.eduardodev.pizza_api.identity.application.AuthenticateUserUseCase;
import com.eduardodev.pizza_api.identity.infrastructure.dto.AuthResponse;
import com.eduardodev.pizza_api.identity.infrastructure.dto.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticateUserUseCase authenticateUserUseCase;

    public AuthController(AuthenticateUserUseCase authenticateUserUseCase) {
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

         String token = authenticateUserUseCase.execute(request.getEmail(), request.getPassword());

         return ResponseEntity.ok(new AuthResponse(token));
    }
}
