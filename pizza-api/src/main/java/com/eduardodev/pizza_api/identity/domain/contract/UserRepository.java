package com.eduardodev.pizza_api.identity.domain.contract;

import com.eduardodev.pizza_api.identity.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
}
