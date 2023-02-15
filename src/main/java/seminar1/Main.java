package seminar1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static seminar1.Person.MALE;

public class Main {
    static HashMap<Integer, Person> population = new HashMap<>();
    static HashMap<String, ArrayList> relations = new HashMap<>();

    public static void initRel(){
        relations.put("Отец", new ArrayList<Integer>());
        relations.put("Мать", new ArrayList<Integer>());
        relations.put("Сын", new ArrayList<Integer>());
        relations.put("Дочь", new ArrayList<Integer>());
        relations.put("Дед", new ArrayList<Integer>());
        relations.put("Бабка", new ArrayList<Integer>());
        relations.put("Внук", new ArrayList<Integer>());
        relations.put("Внучка", new ArrayList<Integer>());
        relations.put("Брат", new ArrayList<Integer>());
        relations.put("Сестра", new ArrayList<Integer>());
        relations.put("Тетя", new ArrayList<Integer>());
        relations.put("Дядя", new ArrayList<Integer>());
        relations.put("Племянник", new ArrayList<Integer>());
        relations.put("Племянница", new ArrayList<Integer>());
        relations.put("Кузен", new ArrayList<Integer>());
        relations.put("Кузина", new ArrayList<Integer>());
        relations.put("Потомок", new ArrayList<Integer>());
        relations.put("Предок", new ArrayList<Integer>());
        relations.put("Родственник", new ArrayList<Integer>());

    }

    static void marriage(Person husband, Person wife){
        husband.setSposes(wife.hashCode());
        husband.sposeRelative.add(wife.hashCode());
        wife.setSposes(husband.hashCode());
        wife.sposeRelative.add(husband.hashCode());
    }

    static void makeChild(Person father, Person mother, Person child){
        population.put(child.hashCode(), child);
        relations.get("Отец").add(father.hashCode());
        relations.get("Мать").add(mother.hashCode());
        if (MALE.equals(child.sex)) {
            relations.get("Сын").add(child.hashCode());
        }else{
            relations.get("Дочь").add(child.hashCode());
        }

        father.childsRelative.add(child.hashCode());
        mother.childsRelative.add(child.hashCode());

        child.directRelative.addAll(father.directRelative);
        child.directRelative.addAll(mother.directRelative);

    }

    static void printPopulation() {
        System.out.println("\nPopulation:");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            System.out.println(entry.getValue().name + "\t - " + entry.getKey().hashCode());
        }
        System.out.println();
    }

    static void printGeneration() {
        System.out.println("\nGeneration:");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            System.out.println(entry.getValue().name + "\t - " + entry.getValue().gen);
        }
        System.out.println();
    }

    static void printDirRel() {
        System.out.println("\nDirect relative");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            System.out.println(entry.getValue().name + "\t - " + entry.getValue().directRelative);
        }
        System.out.println();
    }

    static void printChildsRel() {
        System.out.println("\nChilds relative");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            System.out.println(entry.getValue().name + "\t - " + entry.getValue().childsRelative);
        }
        System.out.println();
    }

    static void printSposesRel() {
        System.out.println("\nSposes relative");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            System.out.println(entry.getValue().name + "\t - " + entry.getValue().sposeRelative);
        }
        System.out.println();
    }

    static void printSummaryRelations() {
        System.out.println("\nRelations summary");
        for (Map.Entry<String, ArrayList> entry : relations.entrySet()) {
            System.out.println(entry.getKey() + "\t - " + entry.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        initRel();

        // Homer + Marge = love
        Person Homer = new Person("Homer", 55, "m");
        population.put(Homer.hashCode(), Homer);
        Homer.gen = (1);

        Person Marge = new Person("Marge", 54, "f");
        population.put(Marge.hashCode(), Marge);
        Marge.gen = (1);

        Person Bart = new Person("Bart", 30, "m");
        Person Lisa = new Person("Lisa", 28, "f");
        Person Maggy = new Person("Maggy", 21, "f");
        Bart.gen = (2);
        Lisa.gen = (2);
        Maggy.gen = (2);

        marriage(Homer, Marge);
        makeChild(Homer, Marge, Bart);
        makeChild(Homer, Marge, Lisa);
        makeChild(Homer, Marge, Maggy);

        // Kirk + Luann = love
        Person Kirk = new Person("Kirk", 63, "m");
        population.put(Kirk.hashCode(), Kirk);
        Kirk.gen = (1);

        Person Luann = new Person("Luann", 58, "f");
        population.put(Luann.hashCode(), Luann);
        Luann.gen = (1);
        marriage(Kirk, Luann);

        Person Milhouse = new Person("Milhouse", 30, "m");
        Milhouse.gen = (2);
        makeChild(Kirk, Luann, Milhouse);

        // Milhouse + Lisa = love
        Person Eliza = new Person("Eliza", 8, "f");
        Eliza.gen = (3);

        marriage(Lisa, Milhouse);
        makeChild(Milhouse, Lisa, Eliza);


        ///////////////////////INFO///////////////////////////////////
        printPopulation();
        printDirRel();
        printChildsRel();
//        printSposesRel();
//        printGeneration();
//        printSummaryRelations();
        //////////////////////////////////////////////////////////////
    }
}