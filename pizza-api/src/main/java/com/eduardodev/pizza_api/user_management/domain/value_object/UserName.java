package com.eduardodev.pizza_api.user_management.domain.value_object;

import java.util.regex.Pattern;

public class UserName {

    private final String name;
    private static final String NAME_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";

    public UserName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty.");
        }
        if (!Pattern.matches(NAME_REGEX, name)) {
            throw new IllegalArgumentException("The name must only contain letters.");
        }
        this.name = formatName(name.trim());
    }

    private String formatName(String rawName) {
        if (rawName.length() == 1) {
            return rawName.toUpperCase();
        }
        return rawName.substring(0, 1).toUpperCase() +
                rawName.substring(1).toLowerCase();
    }
    public String value(){
        return this.name;
    }
}
