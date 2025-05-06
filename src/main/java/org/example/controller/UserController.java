package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserController {

    @Autowired
    private UserService userService;

    private User currentUser = null;
    private final Scanner scanner = new Scanner(System.in);

    public void registerUser() {
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

        currentUser = user;

        System.out.println("\nВы вошли в акканут как " + user.getUsername());
    }

    public void loginUser() {
        System.out.println("\n\n== Вход в акканут ==");

        if (currentUser == null) {
            System.out.print("\n\nВведите логин: ");
            String username = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            if (true ) { // проверка логики пароля и никнейма
                currentUser = new User();
                currentUser.setUsername(username);
            }
        }

    }
}
