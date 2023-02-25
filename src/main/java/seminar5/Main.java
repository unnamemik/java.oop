package seminar5;

import seminar5.model.ComplexCalc;
import seminar5.presenter.Presenter;
import seminar5.view.View;

public class Main {
    public static void main(String[] args) {
        var m = new ComplexCalc();
        var v = new View();
        Presenter presenter = new Presenter(m, v);
        presenter.calculate();
    }

}
