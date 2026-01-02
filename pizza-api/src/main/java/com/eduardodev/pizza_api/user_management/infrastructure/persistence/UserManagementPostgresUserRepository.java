package com.eduardodev.pizza_api.user_management.infrastructure.persistence;

import com.eduardodev.pizza_api.shared.domain.value_object.Email;
import com.eduardodev.pizza_api.shared.domain.value_object.Password;
import com.eduardodev.pizza_api.user_management.domain.contract.UserRepository;
import com.eduardodev.pizza_api.user_management.domain.model.User;
import com.eduardodev.pizza_api.user_management.domain.value_object.UserLastName;
import com.eduardodev.pizza_api.user_management.domain.value_object.UserName;
import com.eduardodev.pizza_api.user_management.infrastructure.persistence.entity.UserEntity;
import com.eduardodev.pizza_api.user_management.infrastructure.persistence.repository.UserManagementUserJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserManagementPostgresUserRepository implements UserRepository {

    private final UserManagementUserJpaRepository userManagementUserJpaRepository;

    public UserManagementPostgresUserRepository(UserManagementUserJpaRepository userManagementUserJpaRepository){
        this.userManagementUserJpaRepository = userManagementUserJpaRepository;
    }

    private  UserEntity toEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getEmail().value(),
                user.getPassword().value(),
                user.getRole(),
                user.getName().value(),
                user.getLastName().value()
        );
    }
    private  User toDomain(UserEntity entity){
        return new User(
                entity.getId(),
                new Email(entity.getEmail()),
                new Password(entity.getPassword()),
                new UserName(entity.getName()),
                new UserLastName(entity.getLastName()),
                entity.getRole()
        );
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = toEntity(user);
        UserEntity savedEntity = userManagementUserJpaRepository.save(userEntity);

        return toDomain(savedEntity);
    }
}
