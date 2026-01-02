package com.eduardodev.pizza_api.user_management.domain.contract;

public interface PasswordHasher {
    String hash(String rawPassword);
}
