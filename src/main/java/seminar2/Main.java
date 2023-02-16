package seminar2;

import java.util.ArrayList;
import java.util.HashMap;

import static seminar2.Engine.*;

public class Main {
    static int exitFlag = 3;
    static HashMap<Integer, Person> population = new HashMap<>();
    static HashMap<String, ArrayList> rel = new HashMap<>();

    public static void main(String[] args) {

        // Homer + Marge = love
        Homer = new Person("Homer", 55, "m");
        population.put(Homer.hashCode(), Homer);
        Homer.gen = (1);

        Marge = new Person("Marge", 54, "f");
        population.put(Marge.hashCode(), Marge);
        Marge.gen = (1);

        Bart = new Person("Bart", 30, "m");
        Lisa = new Person("Lisa", 28, "f");
        Maggy = new Person("Maggy", 21, "f");
        Bart.gen = (2);
        Lisa.gen = (2);
        Maggy.gen = (2);

        Relations.marriage(Homer, Marge);
        Relations.makeChild(Homer, Marge, Bart);
        Relations.makeChild(Homer, Marge, Lisa);
        Relations.makeChild(Homer, Marge, Maggy);

        // Kirk + Luann = love
        Kirk = new Person("Kirk", 63, "m");
        population.put(Kirk.hashCode(), Kirk);
        Kirk.gen = (1);

        Luann = new Person("Luann", 58, "f");
        population.put(Luann.hashCode(), Luann);
        Luann.gen = (1);
        Relations.marriage(Kirk, Luann);

        Milhouse = new Person("Milhouse", 30, "m");
        Milhouse.gen = (2);
        Relations.makeChild(Kirk, Luann, Milhouse);

        // Milhouse + Lisa = love
        Zia = new Person("Zia", 8, "f");
        Zia.gen = (3);

        //pet
        SantasLittleHelper = new Person("SantasLittleHelper", 34, "m");
        population.put(SantasLittleHelper.hashCode(), SantasLittleHelper);
        Bart.pet = SantasLittleHelper;
        SantasLittleHelper.petMaster = Bart;

        Relations.marriage(Lisa, Milhouse);
        Relations.makeChild(Milhouse, Lisa, Zia);


        while (exitFlag != 0) {
            int checkExit = 3;
            while (checkExit != 0) {
                System.out.println(cyan + """
                        \n1. Найти родственников по имени:                                    
                        2. Вывести общую информацию: """ + reset);
                checkExit = userIntegerInput("\nВведите номер действия. Для выхода нажмите 0. " + reset);
                switch (checkExit) {
                    case 1 -> relativesShow();
                    case 2 -> infoShow();
                }
            }
        }
    }
}