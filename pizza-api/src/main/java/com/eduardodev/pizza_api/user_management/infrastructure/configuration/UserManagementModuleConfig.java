package com.eduardodev.pizza_api.user_management.infrastructure.configuration;

import com.eduardodev.pizza_api.user_management.application.CreateUserUseCase;
import com.eduardodev.pizza_api.user_management.domain.contract.PasswordHasher;
import com.eduardodev.pizza_api.user_management.domain.contract.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserManagementModuleConfig {

    @Bean
    public CreateUserUseCase createUserUseCase(
            PasswordHasher passwordHasher,
            UserRepository userRepository
    ){
        return new CreateUserUseCase(passwordHasher, userRepository);
    }
}
