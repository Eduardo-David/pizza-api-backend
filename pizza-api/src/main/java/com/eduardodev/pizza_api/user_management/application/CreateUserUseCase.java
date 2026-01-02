package com.eduardodev.pizza_api.user_management.application;

import com.eduardodev.pizza_api.shared.domain.value_object.Password;
import com.eduardodev.pizza_api.shared.domain.value_object.Role;
import com.eduardodev.pizza_api.shared.domain.value_object.Email;
import com.eduardodev.pizza_api.user_management.domain.contract.PasswordHasher;
import com.eduardodev.pizza_api.user_management.domain.contract.UserRepository;
import com.eduardodev.pizza_api.user_management.domain.model.User;
import com.eduardodev.pizza_api.user_management.domain.value_object.UserLastName;
import com.eduardodev.pizza_api.user_management.domain.value_object.UserName;

public class CreateUserUseCase {

    private final PasswordHasher passwordHasher;
    private final UserRepository userRepository;

    public CreateUserUseCase(PasswordHasher passwordHasher, UserRepository userRepository){
        this.passwordHasher = passwordHasher;
        this.userRepository = userRepository;
    }

    public User execute(String email, String password, String name, String lastName, Role role){
        String passwordHashing = this.passwordHasher.hash(password);

        User user = new User(
                null,
                new Email(email),
                new Password(passwordHashing),
                new UserName(name),
                new UserLastName(lastName),
                role
        );
        return this.userRepository.save(user);
    }
}
