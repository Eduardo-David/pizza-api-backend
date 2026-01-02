package com.eduardodev.pizza_api.identity.domain.model;

import com.eduardodev.pizza_api.shared.domain.value_object.Role;
import com.eduardodev.pizza_api.shared.domain.value_object.Email;
import com.eduardodev.pizza_api.shared.domain.value_object.Password;

public class User {

    private final Role role;
    private final Email email;
    private final Password password;

    public User(Role role, Email email, Password password){
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public String getPassword(){
        return this.password.value();
    }
    public String getRole(){
        return this.role.toString();
    }
    public String getEmail(){
        return this.email.value();
    }
}
