package com.eduardodev.pizza_api.user_management.infrastructure.controller;

import com.eduardodev.pizza_api.shared.domain.value_object.Role;
import com.eduardodev.pizza_api.user_management.application.CreateUserUseCase;
import com.eduardodev.pizza_api.user_management.domain.model.User;
import com.eduardodev.pizza_api.user_management.infrastructure.dto.CreateUserRequest;
import com.eduardodev.pizza_api.user_management.infrastructure.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminUserController {

    private final CreateUserUseCase createUserUseCase;

    public AdminUserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        System.out.println("Controller reached with request: " + request.getEmail());
        User createdUser = createUserUseCase.execute(
                request.getEmail(),
                request.getPassword(),
                request.getName(),
                request.getLastName(),
                request.getRole()
        );

        UserResponse userResponse = new UserResponse(
                createdUser.getId(),
                createdUser.getEmail().value(),
                createdUser.getName().value(),
                createdUser.getLastName().value(),
                createdUser.getRole()
        );
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

}
