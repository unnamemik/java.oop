package seminar5.presenter;

import seminar5.model.ComplexCalc;
import seminar5.model.RatioCalc;
import seminar5.view.View;

import static seminar5.view.ColorConstant.*;

public class Presenter {
    View view;
    ComplexCalc cmplx;

    public Presenter(ComplexCalc cc, View v) {
        cmplx = cc;
        view = v;
    }

    public void calculate() {
        int action = view.getInpInt(CYAN + "Выберите тип чисел:" +
                "\n\t1. Рациональные" +
                "\n\t2. Комплексные" + RESET);

        switch (action) {
            case 1:
                actionRatio();
                break;
            case 2:
                actionComplex();
                break;
            default:
                System.out.println(" ");
        }
    }


    public void actionComplex() {
        cmplx.setX(view.getInpDouble("Введите число x: "));
        cmplx.setA(view.getInpDouble("Введите мнимое число а: "));

        cmplx.setY(view.getInpDouble("Введите число y: "));
        cmplx.setB(view.getInpDouble("Введите мнимое число b: "));

        switch (signSelect()) {
            case 1:
                view.printComplex(YELLOW + "Сумма: " + RESET, cmplx.sum());
                break;
            case 2:
                view.printComplex(YELLOW + "Разность: " + RESET, cmplx.diff());
                break;
            case 3:
                view.printComplex(YELLOW + "Произведение: " + RESET, cmplx.mult());
                break;
            case 4:
                view.printComplex(YELLOW + "Деление: " + RESET, cmplx.divide());
                break;
            default:
                System.out.println(" ");
        }
    }

    public void actionRatio() {
        RatioCalc rc = new RatioCalc();
        rc.setX(view.getInpDouble("Введите число x: "));
        rc.setY(view.getInpDouble("Введите число y: "));

        switch (signSelect()) {
            case 1:
                view.printRatio(YELLOW + "Сумма: " + RESET, rc.sum());
                break;
            case 2:
                view.printRatio(YELLOW + "Разность: " + RESET, rc.diff());
                break;
            case 3:
                view.printRatio(YELLOW + "Произведение: " + RESET, rc.mult());
                break;
            case 4:
                view.printRatio(YELLOW + "Частное: " + RESET, rc.divide());
                break;
            default:
                System.out.println(" ");
        }
    }

    public int signSelect() {
        int sign = view.getInpInt(CYAN + "Выберите действие:" +
                "\n\t1. Сложение" +
                "\n\t2. Вычитание" +
                "\n\t3. Умножение" +
                "\n\t4. Деление" + RESET);
        return sign;
    }
}


