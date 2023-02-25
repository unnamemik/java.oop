package seminar5.presenter;

import seminar5.model.ComplexCalc;
import seminar5.model.RatioCalc;
import seminar5.view.View;

public class Presenter {
    View view;
    ComplexCalc cmplx;

    public Presenter(ComplexCalc cc, View v) {
        cmplx = cc;
        view = v;
    }

    public void calculate() {
        int action = view.getInpInt(View.cyan + "Выберите тип чисел:" +
                "\n\t1. Рациональные" +
                "\n\t2. Комплексные" + View.reset);

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
                view.printComplex(View.yellow + "Сумма: " + View.reset, cmplx.sum());
                break;
            case 2:
                view.printComplex(View.yellow + "Разность: " + View.reset, cmplx.diff());
                break;
            case 3:
                view.printComplex(View.yellow + "Произведение: " + View.reset, cmplx.mult());
                break;
            case 4:
                view.printComplex(View.yellow + "Деление: " + View.reset, cmplx.divide());
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
                view.printRatio(View.yellow + "Сумма: " + View.reset, rc.sum());
                break;
            case 2:
                view.printRatio(View.yellow + "Разность: " + View.reset, rc.diff());
                break;
            case 3:
                view.printRatio(View.yellow + "Произведение: " + View.reset, rc.mult());
                break;
            case 4:
                view.printRatio(View.yellow + "Частное: " + View.reset, rc.divide());
                break;
            default:
                System.out.println(" ");
        }
    }

    public int signSelect() {
        int sign = view.getInpInt(View.cyan + "Выберите действие:" +
                "\n\t1. Сложение" +
                "\n\t2. Вычитание" +
                "\n\t3. Умножение" +
                "\n\t4. Деление" + View.reset);
        return sign;
    }
}


