package ua.university;

import ua.university.ui.MainMenu;
import ua.university.util.ConsoleLogger;
import ua.university.util.ILogger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        new MainMenu(new ConsoleLogger()).run();
    }
}
