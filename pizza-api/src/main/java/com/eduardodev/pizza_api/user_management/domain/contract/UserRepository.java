package com.eduardodev.pizza_api.user_management.domain.contract;

import com.eduardodev.pizza_api.user_management.domain.model.User;

public interface UserRepository {
    User save(User user);
}
