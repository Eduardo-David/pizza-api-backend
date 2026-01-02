package com.eduardodev.pizza_api.user_management.domain.value_object;

import java.util.regex.Pattern;

public class UserLastName {

    private final String lastName;
    private static final String NAME_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";

    public UserLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("The last name cannot be empty.");
        }
        if (!Pattern.matches(NAME_REGEX, lastName)) {
            throw new IllegalArgumentException("The last name must only contain letters.");
        }
        this.lastName = formatLastName(lastName.trim());
    }

    private String formatLastName(String rawName) {
        if (rawName.length() == 1) {
            return rawName.toUpperCase();
        }
        return rawName.substring(0, 1).toUpperCase() +
                rawName.substring(1).toLowerCase();
    }
    public String value(){
        return this.lastName;
    }
}
