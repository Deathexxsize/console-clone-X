package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    private UserController userController;

    public void menu() {
        while (true) {
            System.out.println("\n\n\n== Menu ==");
            System.out.println("\n\n1. Создать аккаунт\n2. Войти в акканут");
            System.out.print("Выбрать: ");
            int choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {
                case 1:
                    userController.registerUser();
                    break;
                case 2:
                    userController.loginUser();
                    break;
                default:
                    System.err.println("\nНеизвестный символ");
            }
        }
    }

    public void userPanel() {
        System.out.println("\n\n\n== Главное меню ==");

        System.out.println("\n\n0. Выйти из аккаунта\n1. Профиль\n2. Поиск пользователя\n3. Посмотреть ленту новостей");
        System.out.print("Выбрать: ");
        int choose = new Scanner(System.in).nextInt();

        while (true) {
            switch (choose) {
                case 0:
                    userController.currentUser = null;
                    System.out.println("\nВы успешно вышли из аккаунта");
                    menu();
                    break;
                case 1:
                    // профиль
                    break;
                case 2:
                    // лента новостей
                    break;
                default:
                    System.err.println("\nНе верное значение");
                    continue;
            }
            break;
        }
    }
}
