package com.eduardodev.pizza_api.identity.domain.contract;

public interface PasswordService {
    boolean matches(String rawPassword, String encodedPassword);
}
