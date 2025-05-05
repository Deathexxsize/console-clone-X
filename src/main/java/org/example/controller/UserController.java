package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@Component
public class UserController {

    @Autowired
    private UserService userService;

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n== Регистрация аккаунта ==");

        System.out.print("\n\nПридумайте никнейм: ");
        String username = scanner.nextLine();
        System.out.print("Введите email: ");
        String email = scanner.nextLine();
        System.out.print("Придумайте пароль: ");
        String password = scanner.nextLine();

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        userService.createUser(user);
    }
}
