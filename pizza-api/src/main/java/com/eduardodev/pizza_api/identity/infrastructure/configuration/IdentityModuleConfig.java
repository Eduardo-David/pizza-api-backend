package com.eduardodev.pizza_api.identity.infrastructure.configuration;

import com.eduardodev.pizza_api.identity.application.AuthenticateUserUseCase;
import com.eduardodev.pizza_api.identity.domain.contract.PasswordService;
import com.eduardodev.pizza_api.shared.domain.contract.TokenService;
import com.eduardodev.pizza_api.identity.domain.contract.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdentityModuleConfig {

    @Bean
    public AuthenticateUserUseCase authenticateUserUseCase(
            UserRepository userRepository,
            PasswordService passwordService,
            TokenService tokenService
    ) {

        return new AuthenticateUserUseCase(userRepository, passwordService, tokenService);
    }
}
