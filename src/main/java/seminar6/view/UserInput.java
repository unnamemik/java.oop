package seminar6.view;

import java.util.Scanner;

import static seminar6.view.Constants.RED;
import static seminar6.view.Constants.RESET;


public class UserInput {
    public static String getInputStr(String inp) {
        Scanner sc = new Scanner(System.in);
        String inputStr;
        while (true) {
            System.out.println(inp);
            try {
                inputStr = sc.next();
                break;
            } catch (NumberFormatException e) {
                System.out.println(RED + "Неверный ввод! Введите целое число!" + RESET);
            }
        }
        return inputStr;
    }
    public static int getInputInt(String msg) {
        Scanner sc = new Scanner(System.in);
        int inputStr;
        while (true) {
            System.out.print(msg);
            try {
                inputStr = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println(RED + "Неверный ввод! Введите целое число!" + RESET);
            }
        }
        return inputStr;
    }
}
