package org.example.controller;

import org.example.entity.User;
import org.example.service.DataValidator;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    @Lazy
    private Menu menu;

    public User currentUser = null;
    private final Scanner scanner = new Scanner(System.in);
    private final DataValidator dataValidator = new DataValidator();

    public void registerUser() {
        while (true) {
            System.out.println("\n\n== Регистрация аккаунта ==");

            System.out.print("\n\nПридумайте никнейм: ");
            String username = scanner.nextLine();
            System.out.print("Введите email: ");
            String email = scanner.nextLine();
            System.out.print("Придумайте пароль: ");
            String password = scanner.nextLine();

            if (!dataValidator.isValidUsername(username)) {
                System.out.println("\n❌ Никнейм должен быть не пустым и не короче 4 символов.");
                continue;
            }

            if (!dataValidator.isValidEmail(email)) {
                System.err.println("\n❌ Email должен содержать @gmail.com или @mail.ru.");
                continue;
            }

            if (!dataValidator.isValidPassword(password)) {
                System.err.println("\n❌ Пароль должен быть не пустым и не короче 8 символов.");
                continue;
            }

            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);

            userService.createUser(user);
            currentUser = user;
            System.out.println("\n✅ Вы вошли в аккаунт как " + user.getUsername());
            menu.userPanel();
            break;
        }

    }

    public void loginUser() {
        System.out.println("\n\n== Вход в акканут ==");

        while (currentUser == null) {
            System.out.print("\nВведите логин: ");
            String username = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            if (userService.userExists(username, password)) {
                currentUser = new User();
                currentUser.setUsername(username);
                System.out.println("\n✅ Вы вошли в аккаунт как " + username);
                menu.userPanel();
            } else {
                System.err.println("\n❌ Неверный логин или пароль. Попробуйте снова.");
            }
        }

    }
}
