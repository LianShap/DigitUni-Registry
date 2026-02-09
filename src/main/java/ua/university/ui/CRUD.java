package ua.university.ui;

import ua.university.domain.Person;
import ua.university.domain.Student;
import ua.university.domain.enums.StudentStatus;
import ua.university.domain.enums.StudyForm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    private static String readNonEmptyString(String message) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) System.out.println("Error: field cannot be empty.");
        } while (input.isEmpty());
        return input;
    }

    public static int intInRange(String message, int min, int max) {
        int value;
        while (true) {
            try {
                System.out.print(message);
                value = Integer.parseInt(scanner.nextLine());
                if (value < min || value > max)
                    System.out.println("Error: value must be between " + min + " and " + max);
                else return value;
            } catch (NumberFormatException e) {
                System.out.println("Error: enter a number.");
            }
        }
    }

    public static void create() {
        String id = readNonEmptyString("Enter ID: ");
        String lastName = readNonEmptyString("Enter Last Name: ");
        String firstName = readNonEmptyString("Enter First Name: ");
        String middleName = readNonEmptyString("Enter Middle Name: ");
        int year = intInRange("Enter birth year: ", 1900, LocalDate.now().getYear());
        int month = intInRange("Enter birth month: ", 1, 12);
        int day = intInRange("Enter birth day: ", 1, 31);
        LocalDate birthDate = LocalDate.of(year, month, day);
        String email = readNonEmptyString("Enter Email: ");
        String phone = readNonEmptyString("Enter Phone: ");

        String studentId = readNonEmptyString("Enter Student ID: ");
        int course = intInRange("Enter course (1-6): ", 1, 6);
        String group = readNonEmptyString("Enter group: ");
        int entryYear = intInRange("Enter entry year: ", 2000, LocalDate.now().getYear());

        System.out.println("1 - Budget\n2 - Contract");
        int choice = intInRange("Your choice: ", 1, 2);
        StudyForm form = choice == 1 ? StudyForm.BUDGET : StudyForm.CONTRACT;

        System.out.println("1 - Studying\n2 - Academic leave\n3 - Expelled");
        int choice2 = intInRange("Your choice: ", 1, 3);
        StudentStatus status = switch (choice2) {
            case 1 -> StudentStatus.STUDYING;
            case 2 -> StudentStatus.ACADEMIC_LEAVE;
            default -> StudentStatus.EXPELLED;
        };

        Student s = new Student(id, lastName, firstName, middleName, birthDate, email, phone,
                studentId, course, group, entryYear, form, status);

        students.add(s);
        System.out.println("Student registered successfully!");
    }

    public static void showStudents() {
        if (students.isEmpty()) System.out.println("No students found.");
        else students.forEach(System.out::println);
    }

    public static void update() {
        String id = readNonEmptyString("Enter student ID to update: ");
        Student s = students.stream().filter(st -> st.getStudentId().equals(id)).findFirst().orElse(null);
        if (s == null) {
            System.out.println("No student found.");
            return;
        }
        System.out.println("Updating student: " + s.getFullName());
        System.out.println("1-ID 2-Name 3-Birthdate 4-Email 5-Phone 6-Course 7-Group 8-EntryYear 9-StudyForm 10-Status 0-Exit");
        int choice = intInRange("Your choice: ", 0, 10);
        switch (choice) {
            case 1 -> s.setId(readNonEmptyString("New ID: "));
            case 2 -> {
                s.setLastName(readNonEmptyString("New Last Name: "));
                s.setFirstName(readNonEmptyString("New First Name: "));
                s.setMiddleName(readNonEmptyString("New Middle Name: "));
            }
            case 3 -> {
                int year = intInRange("Enter birth year: ", 1900, LocalDate.now().getYear());
                int month = intInRange("Enter birth month: ", 1, 12);
                int day = intInRange("Enter birth day: ", 1, 31);
                s.setBirthDate(LocalDate.of(year, month, day));
            }
            case 4 -> s.setEmail(readNonEmptyString("New Email: "));
            case 5 -> s.setPhone(readNonEmptyString("New Phone: "));
            case 6 -> s.setCourse(intInRange("New course: ", 1, 6));
            case 7 -> s.setGroup(readNonEmptyString("New group: "));
            case 8 -> s.setEntryYear(intInRange("New entry year: ", 2000, LocalDate.now().getYear()));
            case 9 -> {
                System.out.println("1 - Budget\n2 - Contract");
                s.setStudyForm(intInRange("Your choice: ", 1, 2) == 1 ? StudyForm.BUDGET : StudyForm.CONTRACT);
            }
            case 10 -> {
                System.out.println("1 - Studying\n2 - Academic leave\n3 - Expelled");
                int stChoice = intInRange("Your choice: ", 1, 3);
                s.setStatus(stChoice == 1 ? StudentStatus.STUDYING : stChoice == 2 ? StudentStatus.ACADEMIC_LEAVE : StudentStatus.EXPELLED);
            }
            case 0 -> {
                System.out.println("Exiting...");
                return;
            }
            default -> System.out.println("Invalid choice");
        }
        System.out.println("Updated successfully!");
    }

    public static void delete() {
        String id = readNonEmptyString("Enter student ID to delete: ");
        boolean removed = students.removeIf(s -> s.getStudentId().equals(id));
        System.out.println(removed ? "Deleted successfully!" : "Student not found.");
    }
}
