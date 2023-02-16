package seminar2;

import java.util.Scanner;

public class Engine {
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String yellow = "\u001B[33m";
    public static final String cyan = "\u001B[36m";

    public static Person Homer;
    public static Person Marge;
    public static Person Bart;
    public static Person Lisa;
    public static Person Maggy;
    public static Person Kirk;
    public static Person Luann;
    public static Person Milhouse;
    public static Person Zia;
    public static Person SantasLittleHelper;

    public static int userIntegerInput(String msg) {
        Scanner sc = new Scanner(System.in);
        int inputStr;
        while (true) {
            System.out.print(msg);
            try {
                inputStr = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println(red + "Неверный ввод! Введите целое число!" + reset);
            }
        }
        return inputStr;
    }

    public static void infoShow() {                   //////////////////       Метод выбора по параметрам
        System.out.println(yellow + """
                \n1. Показать всех персонажей
                2. Показать прямую родственную связь
                3. Показать поколения
                4. Показать супружеские связи
                5. Показать связь с детьми""" + reset);

        int checkExit = 3;
        while (checkExit != 0) {
            checkExit = userIntegerInput(cyan + "\nВведите номер параметра для поиска. Для выхода в предыдущее меню нажмите 0. " + reset);
            switch (checkExit) {
                case 1 -> {
                    Relations.printPopulation();
                }
                case 2 -> {
                    Relations.printDirRel();
                }
                case 3 -> {
                    Relations.printGeneration();
                }
                case 4 -> {
                    Relations.printSposesRel();
                }
                case 5 -> {
                    Relations.printChildsRel();
                }
            }
            System.out.println(yellow + "\nПоиск завершен." + reset);
        }
    }

    public static Person choosePers() {                   //////////////////       Метод выбора по персонажам
        System.out.println(yellow + """
                \n1. Homer
                2. Marge
                3. Bart
                4. Lisa
                5. Maggy
                6. Kirk
                7. Luanna
                8. Milhouse
                9. Zia
                10. собака SantasLittleHelper""" + reset);

        int checkExit = 11;
        while (checkExit != 0) {
            checkExit = userIntegerInput(cyan + "\nВведите номер персонажа. Для выхода в предыдущее меню нажмите 0. " + reset);
            switch (checkExit) {
                case 1 -> {
                    return Homer;
                }
                case 2 -> {
                    return Marge;
                }
                case 3 -> {
                    return Bart;
                }
                case 4 -> {
                    return Lisa;
                }
                case 5 -> {
                    return Maggy;
                }
                case 6 -> {
                    return Kirk;
                }
                case 7 -> {
                    return Luann;
                }
                case 8 -> {
                    return Milhouse;
                }
                case 9 -> {
                    return Zia;
                }
                case 10 -> {
                    return SantasLittleHelper;
                }
            }
            System.out.println(yellow + "\nПоиск завершен." + reset);
        }
        return null;
    }

    public static void relativesShow() {                   //////////////////       Метод выбора по параметрам
        System.out.println(yellow + """
                \n1. Показать родителей
                2. Показать дедушек/бабушек
                3. Показать дядю/тетю
                4. Показать племянников
                5. Показать братьев/сестер
                6. Показать питомца""" + reset);

        int checkExit = 7;
        while (checkExit != 0) {
            checkExit = userIntegerInput(cyan + "\nВведите номер параметра для поиска родственников. Для выхода в предыдущее меню нажмите 0. " + reset);
            switch (checkExit) {
                case 1 -> {
                    Relations.findParents(choosePers());
                }
                case 2 -> {
                    Relations.findGrands(choosePers());
                }
                case 3 -> {
                    Relations.findUncles(choosePers());
                }
                case 4 -> {
                    Relations.findCousins(choosePers());
                }
                case 5 -> {
                    Relations.findSibs(choosePers());
                }
                case 6 -> {
                    Relations.findPet(choosePers());
                }
            }
            System.out.println(yellow + "\nПоиск завершен." + reset);
        }
    }
}
