package com.eduardodev.pizza_api.shared.domain.value_object;

import java.util.regex.Pattern;

public class Password {

    private final String password;
    private static final String PASSWORD_REGEX =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!.])(?=\\S+$).{8,}$";
    private static final Pattern PATTERN = Pattern.compile(PASSWORD_REGEX);

    public Password(String password) {
        if (password == null){
            throw new IllegalArgumentException("the password cannot be null");
        }
        if (password.trim().isEmpty()) {
            throw new IllegalArgumentException("the password cannot be trim");
        }
        if (!PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException(
                    "The password must have a minimum of 8 characters, one uppercase letter, one number, and one special symbol."
            );
        }
        this.password = password;
    }

    public String value(){
        return this.password;
    }
}
