package seminar5.view;

import seminar5.model.Complex;

import java.util.Scanner;

public class View {
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String yellow = "\u001B[33m";
    public static final String cyan = "\u001B[36m";


    public Double getInpDouble(String inp) {
        Scanner sc = new Scanner(System.in);
        double inputStr;
        while (true) {
            System.out.println(inp);
            try {
                inputStr = Double.parseDouble(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println(red + "Неверный ввод! Введите рациональное число!" + reset);
            }
        }
        return inputStr;
    }

    public Integer getInpInt(String inp) {
        Scanner sc = new Scanner(System.in);
        int inputStr;
        while (true) {
            System.out.println(inp);
            try {
                inputStr = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println(red + "Неверный ввод! Введите целое число!" + reset);
            }
        }
        return inputStr;
    }

    public void printRatio(String str, double data) {
        System.out.println(str + data);
    }

    public void printComplex(String str, Complex data) {
        System.out.println(str + data);
    }
}
