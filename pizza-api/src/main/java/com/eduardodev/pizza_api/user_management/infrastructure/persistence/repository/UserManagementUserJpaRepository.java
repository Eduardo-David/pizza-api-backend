package com.eduardodev.pizza_api.user_management.infrastructure.persistence.repository;
import com.eduardodev.pizza_api.user_management.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserManagementUserJpaRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}
