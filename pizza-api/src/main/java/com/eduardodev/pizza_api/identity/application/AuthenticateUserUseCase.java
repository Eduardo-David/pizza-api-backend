package com.eduardodev.pizza_api.identity.application;

import com.eduardodev.pizza_api.identity.domain.contract.PasswordService;
import com.eduardodev.pizza_api.shared.domain.contract.TokenService;
import com.eduardodev.pizza_api.identity.domain.contract.UserRepository;
import com.eduardodev.pizza_api.identity.domain.model.User;

public class AuthenticateUserUseCase {
    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final TokenService tokenService;

    public AuthenticateUserUseCase(
            UserRepository userRepository,
            PasswordService passwordService,
            TokenService tokenService)
    {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
        this.tokenService = tokenService;
    }

    public String execute(String email, String password){
        User user = this.userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Bad credentials"));

        boolean passwordsMatch = this.passwordService.matches(password, user.getPassword());
        if (!passwordsMatch){
            throw new RuntimeException("Incorrect password");
        }
        return this.tokenService.generateToken(user);
    }

}
