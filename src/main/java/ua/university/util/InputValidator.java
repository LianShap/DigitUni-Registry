package ua.university.util;

import java.util.Scanner;

/**
 * Утилітарний клас для валідації вводу з консолі.
 * <p>
 * Містить статичні методи для безпечного зчитування
 * даних від користувача.
 * </p>
 */

public class InputValidator {

    /**
     * Зчитує непорожній рядок з консолі.
     * //@param message повідомлення для користувача
     * @param sc scanner для читання вводу
     * @return непорожній рядок
     */
    public static String readNonEmptyString(Scanner sc) {
        while (true) {
            //System.out.print(message);
            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Поле не може бути порожнім.");
        }
    }

    // Курс 1–6
    /**
     * Зчитує номер курсу студента.
     * @return номер курсу (1–6)
     */
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

    /**
     * Зчитує вибір пункту меню.
     * @param sc  scanner для читання вводу
     * @param min мінімально допустиме значення
     * @param max максимально допустиме значення
     * @return коректний вибір меню
     */
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


    /**
     * Зчитує назву групи за заданим шаблоном.

     * @return назва групи у коректному форматі
     */
    public static String readGroup(Scanner sc) {
        while (true) {
            System.out.print("Введіть групу (напр. ІПЗ-1): ");
            String input = sc.nextLine().trim();

            if (input.matches("[A-Za-zА-Яа-яІіЇїЄє]{2,5}-\\d{2}")) {
                return input;
            }

            System.out.println("Некоректний формат групи.");
        }
    }


}
