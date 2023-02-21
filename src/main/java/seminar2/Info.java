package seminar2;

import java.util.Map;

import static seminar2.Main.population;
import static seminar2.Printer.*;

public interface Info {
    //////////////////////////////////////////////////////////// INFO //////////////////////////////////////////////////////
    static void getPopulationInfo() {
        System.out.println("\nPopulation:");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            //return (entry.getValue().name + "\t" + entry.getKey().hashCode());
            String txt = (entry.getValue().getName() + "\t" + entry.getKey().hashCode());
            printGetPopulationInfo(txt);
        }
    }

    static void generationInfo() {
        System.out.println("\nGeneration:");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            String txt = (entry.getValue().getName() + "\t" + entry.getValue().getGen());
            printgenerationInfo(txt);
        }
    }

    static void dirRelInfo() {
        System.out.println("\nDirect relative");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            String txt = (String)(entry.getValue().getName() + "\t" + entry.getValue().directRelative);
            printdirRelInfo(txt);
        }
    }

    static void childsRelInfo() {
        System.out.println("\nChilds relative");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            String txt = (String)(entry.getValue().getName() + "\t" + entry.getValue().childsRelative);
            printchildsRelInfo(txt);
        }
    }

    static void sposesRelInfo() {
        System.out.println("\nSposes relative");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            String txt = (String)(entry.getValue().getName() + "\t" + entry.getValue().sposeRelative);
            printsposesRelInfo(txt);
        }
    }
    //////////////////////////////////////////////////////////// INFO //////////////////////////////////////////////////////
}

