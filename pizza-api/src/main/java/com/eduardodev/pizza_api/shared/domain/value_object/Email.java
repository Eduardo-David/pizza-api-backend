package com.eduardodev.pizza_api.shared.domain.value_object;
import java.util.regex.Pattern;

public class Email {

    private final String email;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);


    public Email(String email) {
        if (email == null){
            throw new IllegalArgumentException("The email cannot be null");
        }
        if (email.trim().isEmpty()){
            throw new IllegalArgumentException("The email cannot be empty");
        }
        if (!isValidFormat(email)){
            throw new IllegalArgumentException("The email format is invalid");
        }
        this.email = email;
    }

    private static boolean isValidFormat(String email) {
        return PATTERN.matcher(email).matches();
    }
    public String value() {
        return email;
    }
}
