package com.eduardodev.pizza_api.user_management.domain.model;

import com.eduardodev.pizza_api.shared.domain.value_object.Password;
import com.eduardodev.pizza_api.shared.domain.value_object.Role;
import com.eduardodev.pizza_api.shared.domain.value_object.Email;
import com.eduardodev.pizza_api.user_management.domain.value_object.UserLastName;
import com.eduardodev.pizza_api.user_management.domain.value_object.UserName;

public class User{

    private final Integer id;
    private final Email email;
    private final Password password;
    private final UserName name;
    private final UserLastName lastName;
    private final Role role;


    public User(Integer id, Email email, Password password, UserName name, UserLastName lastName, Role role){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
    }

    public Integer getId() {
        return this.id;
    }

    public Email getEmail() {
        return this.email;
    }

    public Password getPassword() {
        return this.password;
    }

    public UserName getName() {
        return this.name;
    }

    public UserLastName getLastName() {
        return lastName;
    }

    public Role getRole() {
        return this.role;
    }
}
