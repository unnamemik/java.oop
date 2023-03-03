package seminar5.view;

import seminar5.model.Complex;

import java.util.Scanner;

import static seminar5.view.ColorConstant.RED;
import static seminar5.view.ColorConstant.RESET;

public class View {

    public Double getInpDouble(String inp) {
        Scanner sc = new Scanner(System.in);
        double inputStr;
        while (true) {
            System.out.println(inp);
            try {
                inputStr = Double.parseDouble(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println(RED + "Неверный ввод! Введите рациональное число!" + RESET);
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
                System.out.println(RED + "Неверный ввод! Введите целое число!" + RESET);
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
