package org.example.controller;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final UserController userController;

    public Menu(UserController userController) {
        this.userController = userController;
    }

    public void menu() {

        System.out.println("\n\n\n== Menu ==");
        System.out.println("\n\n1. Создать аккаунт\n2. Войти в акканут");
        System.out.print("Выбрать: ");
        int choose = scanner.nextInt();
        scanner.nextLine(); // прочистить буфер

        switch (choose) {
            case 1:
                userController.registerUser();
                break;
            case 2:
                System.out.println("Пока не реализовано");
                break;
            default:
                System.err.println("\nНеизвестный символ");
        }
    }
}
