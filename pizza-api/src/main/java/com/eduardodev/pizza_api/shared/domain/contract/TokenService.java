package com.eduardodev.pizza_api.shared.domain.contract;

import com.eduardodev.pizza_api.identity.domain.model.User;

public interface TokenService {
    String generateToken(User user);
}
