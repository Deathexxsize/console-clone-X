package org.example;


import org.example.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class MyApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyApp.class, args);

        UserController userController = context.getBean(UserController.class);

        System.out.println("== Menu ==");
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
