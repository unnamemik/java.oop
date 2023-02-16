package seminar2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import static seminar2.Main.population;

public interface Relations {
    static void marriage(Person husband, Person wife) {
        husband.setSposes(wife.hashCode());
        husband.sposeRelative.add(wife.hashCode());
        wife.setSposes(husband.hashCode());
        wife.sposeRelative.add(husband.hashCode());
    }

    static void makeChild(Person father, Person mother, Person child) {
        population.put(child.hashCode(), child);

        father.childsRelative.add(child.hashCode());
        mother.childsRelative.add(child.hashCode());

        child.directRelative.addAll(father.directRelative);
        child.directRelative.addAll(mother.directRelative);

    }

    static Person findViaHash(int hash) {
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            if (entry.getValue().hashCode() == hash) {
                //System.out.println(entry.getValue().name + "\t - " + entry.getKey().hashCode());
                return entry.getValue();
            }
        }
        return null;
    }

    static void findParents(Person pers) {
        System.out.println("\n" + pers.name + ", родители:");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            if (entry.getValue().childsRelative.contains(pers.hashCode()) & entry.getValue().gen == pers.gen - 1) {
                System.out.println(entry.getValue().name + "\t" + entry.getKey().hashCode());
            }
        }
    }

    static void findChildren(Person pers) {
        Iterator iter = pers.childsRelative.iterator();
        System.out.println("\n" + pers.name + ", дети:");
        if (!pers.childsRelative.isEmpty()) {
            while (iter.hasNext()) {
                Person curPers = findViaHash(iter.next().hashCode());
                System.out.println(curPers.name + "\t" + curPers.hashCode());
            }
        }
    }

    static void findSibs(Person pers) {
        HashSet<Integer> childSet = new HashSet<>(1);
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            if (entry.getValue().childsRelative.contains(pers.hashCode()) & entry.getValue().gen == pers.gen - 1) {
                if (!childSet.contains(entry.getKey().hashCode())) {
                    childSet.addAll(entry.getValue().childsRelative);
                }
            }
        }
        System.out.println("\n" + pers.name + ", брат/сестра:");
        for (Integer elem : childSet)
            System.out.println(findViaHash(elem).name + "\t" + elem);
    }

    static void findPet(Person pers) throws NullPointerException {
        System.out.println("\n" + pers.name + ", питомцы:");
        if (!pers.pet.name.isEmpty()) {
            System.out.println(pers.pet.name + "\t" + pers.pet.hashCode());
        }
    }

    static void findGrands(Person pers) {
        HashSet<Integer> grands = new HashSet<>(1);
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            if (entry.getValue().gen == pers.gen - 2) {
                grands.add(entry.getKey().hashCode());
            }
        }
        System.out.println("\n" + pers.name + ", дедушки/бабушки:");
        for (Integer elem : grands)
            System.out.println(findViaHash(elem).name + "\t" + elem);
    }

    static void findUncles(Person pers) {
        HashSet<Integer> setUncles = new HashSet<>(1);
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            if (entry.getValue().gen == pers.gen - 2) {
                setUncles.add(entry.getKey().hashCode());
            }
        }
        System.out.println("\n" + pers.name + ", дяди/тети:");
        HashSet<Person> sortUncles = new HashSet<>(1);
        for (Integer elem : setUncles)
            if (!findViaHash(elem).childsRelative.isEmpty()) {
                for (Integer sibs : findViaHash(elem).childsRelative) {
                    Person curPers = findViaHash(sibs);
                    if (!curPers.childsRelative.contains(pers.hashCode())) {
                        sortUncles.add(curPers);
                    }
                }
            }
        for (Person uncle : sortUncles) {
            System.out.println(uncle.name + "\t" + uncle.hashCode());
        }
    }

    static void findCousins(Person pers) {
        HashSet<Integer> childSet = new HashSet<>(1);
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            if (entry.getValue().childsRelative.contains(pers.hashCode()) & entry.getValue().gen == pers.gen - 1) {
                if (!childSet.contains(entry.getKey().hashCode())) {
                    childSet.addAll(entry.getValue().childsRelative);
                }
            }
        }
        System.out.println("\n" + pers.name + ", племянник/племянница:");
        for (Integer elem : childSet)
            for (Integer children : findViaHash(elem).childsRelative) {
                System.out.println(findViaHash(children).name + "\t" + children);
            }
        //System.out.println(findViaHash(elem).name + "\t" + elem);
    }

    //////////////////////////////////////////////////////////// INFO //////////////////////////////////////////////////////
    static void printPopulation() {
        System.out.println("\nPopulation:");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            System.out.println(entry.getValue().name + "\t" + entry.getKey().hashCode());
        }
    }

    static void printGeneration() {
        System.out.println("\nGeneration:");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            System.out.println(entry.getValue().name + "\t" + entry.getValue().gen);
        }
    }

    static void printDirRel() {
        System.out.println("\nDirect relative");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            System.out.println(entry.getValue().name + "\t" + entry.getValue().directRelative);
        }
    }

    static void printChildsRel() {
        System.out.println("\nChilds relative");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            System.out.println(entry.getValue().name + "\t" + entry.getValue().childsRelative);
        }
    }

    static void printSposesRel() {
        System.out.println("\nSposes relative");
        for (Map.Entry<Integer, Person> entry : population.entrySet()) {
            System.out.println(entry.getValue().name + "\t" + entry.getValue().sposeRelative);
        }
    }
    //////////////////////////////////////////////////////////// INFO //////////////////////////////////////////////////////
}
