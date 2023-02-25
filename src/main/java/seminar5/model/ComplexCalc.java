package seminar5.model;

import seminar5.Logger;

public class ComplexCalc extends SetDigits implements Model<Complex> {

    SetDigits cc = new SetDigits();

    @Override
    public Complex sum() {
        Logger.logData("Сумма комплексных чисел: " + (x + y) + " " + (a + b));
        return new Complex((x + a), (y + b));
    }

    @Override
    public Complex mult() {
        Logger.logData("Произведение комплексных чисел: " + (x * a - y * b) + " " + (y * a + b * x));
        return new Complex((x * a - y * b), (y * a + b * x));
    }

    @Override
    public Complex divide() {
        Logger.logData("Частное комплексных чисел: " + (x * a + y * b) / (y * y + b * b) + " " + (y * a - b * x) / (y * y + b * b));
        return new Complex((x * a + y * b) / (y * y + b * b), (y * a - b * x) / (y * y + b * b));
    }

    @Override
    public Complex diff() {
        Logger.logData("Разность комплексных чисел: " + (x - a) + " " + (y - b));
        return new Complex((x - a), (y - b));
    }
}
