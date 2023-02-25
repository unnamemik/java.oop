package seminar5.model;

import seminar5.Logger;

public class RatioCalc extends SetDigits implements Model<Double> {

    @Override
    public Double sum() {
        Logger.logData("Сумма чисел: " + (x + y));
        return (x + y);
    }

    @Override
    public Double mult() {
        Logger.logData("Произведение чисел: " + (x * y));
        return (x * y);
    }

    @Override
    public Double divide() {
        Logger.logData("Деление чисел: " + (x / y));
        return (x / y);
    }

    @Override
    public Double diff() {
        Logger.logData("Разница чисел: " + (x - y));
        return (x - y);
    }
}
