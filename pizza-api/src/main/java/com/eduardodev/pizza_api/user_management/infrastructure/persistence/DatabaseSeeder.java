package com.eduardodev.pizza_api.user_management.infrastructure.persistence;

import com.eduardodev.pizza_api.shared.domain.value_object.Role;
import com.eduardodev.pizza_api.user_management.infrastructure.persistence.entity.UserEntity;
import com.eduardodev.pizza_api.user_management.infrastructure.persistence.repository.UserManagementUserJpaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final UserManagementUserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${application.security.admin.email}")
    private String adminEmail;

    @Value("${application.security.admin.password}")
    private String adminPassword;

    @Value("${application.security.admin.name}")
    private String adminName;

    @Value("${application.security.admin.last-name}")
    private String adminLastName;

    public DatabaseSeeder(UserManagementUserJpaRepository userJpaRepository, PasswordEncoder passwordEncoder) {
        this.userJpaRepository = userJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        if (userJpaRepository.findByEmail(adminEmail).isPresent()) {
            System.out.println("System info: Admin user already exists.");
            return;
        }

        System.out.println("System info: Creating root Admin user...");

        UserEntity admin = new UserEntity();
        admin.setEmail(adminEmail);
        admin.setPassword(passwordEncoder.encode(adminPassword));
        admin.setRole(Role.GENERAL_ADMINISTRATOR);
        admin.setName(adminName);
        admin.setLastName(adminLastName);

        userJpaRepository.save(admin);
        System.out.println("System info: Admin user created successfully.");
    }
}
