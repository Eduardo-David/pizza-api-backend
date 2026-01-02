package com.eduardodev.pizza_api.identity.infrastructure.persistence;

import com.eduardodev.pizza_api.identity.domain.contract.UserRepository;
import com.eduardodev.pizza_api.identity.infrastructure.persistence.repository.IdentityUserJpaRepository;
import com.eduardodev.pizza_api.shared.domain.value_object.Role;
import com.eduardodev.pizza_api.identity.domain.model.User;
import com.eduardodev.pizza_api.shared.domain.value_object.Email;
import com.eduardodev.pizza_api.shared.domain.value_object.Password;
import com.eduardodev.pizza_api.identity.infrastructure.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class IdentityPostgresUserRepository implements UserRepository {

    private final IdentityUserJpaRepository jpaRepository;

    public IdentityPostgresUserRepository(IdentityUserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    private User toDomain(UserEntity entity) {
        return new User(
                Role.valueOf(entity.getRole().name()),
                new Email(entity.getEmail()),
                new Password(entity.getPassword())
        );
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> entityOptional = jpaRepository.findByEmail(email);
        return entityOptional.map(this::toDomain);
    }
}
