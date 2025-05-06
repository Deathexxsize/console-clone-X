package org.example.service;


public class DataValidator {
    public boolean isValidUsername(String username) {
        if (username.isEmpty()) { return false; }
        if (username.length() < 4) { return false; }
        return true;
    }

    public boolean isValidPassword(String password) {
        if (password.isEmpty()) { return false; }
        if (password.length() < 8) { return false; }
        return true;
    }

    public boolean isValidEmail(String email) {
        if (email.isEmpty()) { return false; }
        if (!email.contains("@gmail.com") && !email.contains("@mail.ru")) { return false; }
        return true;
    }
}
