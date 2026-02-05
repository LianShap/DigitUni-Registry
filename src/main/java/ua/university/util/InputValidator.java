package ua.university.util;

import java.util.Scanner;

public class InputValidator {

    public static String readNonEmptyString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Поле не може бути порожнім.");
        }
    }

    // Курс 1–6
    public static int readCourse(Scanner sc) {
        while (true) {
            try {
                System.out.print("Введіть курс (1-6): ");
                int course = Integer.parseInt(sc.nextLine());

                if (course >= 1 && course <= 6) {
                    return course;
                }
                System.out.println("Курс має бути від 1 до 6.");
            } catch (NumberFormatException e) {
                System.out.println("Введіть число.");
            }
        }
    }

    // Вибір пункту меню
    public static int readMenuOption(Scanner sc, int min, int max) {
        while (true) {
            try {
                System.out.print("Ваш вибір: ");
                int option = Integer.parseInt(sc.nextLine());

                if (option >= min && option <= max) {
                    return option;
                }
                System.out.printf("Введіть число від %d до %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Введіть коректне число.");
            }
        }
    }


    // Група
    // Група за шаблоном
    public static String readGroup(Scanner sc) {
        while (true) {
            System.out.print("Введіть групу (напр. SE-21): ");
            String input = sc.nextLine().trim();

            if (input.matches("[A-Za-zА-Яа-яІіЇїЄє]{2,5}-\\d{2}")) {
                return input;
            }

            System.out.println("Некоректний формат групи.");
        }
    }


}
