package seminar2;

import java.util.HashSet;

public class Person {
    private int age;
    public String name;
    public String sex;
    public int gen;

    public Person pet;
    public Person petMaster;


    public int sposes;
    public HashSet<Integer> directRelative = new HashSet<>(1);
    public HashSet<Integer> sposeRelative = new HashSet<>(1);
    public HashSet<Integer> childsRelative = new HashSet<>(1);

    public Person(String name, int age, String sex) {
        this.directRelative.add(this.hashCode());
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setSposes(int sposes) {
        this.sposes = sposes;
    }

    public int getSposes() {
        return sposes;
    }

    @Override
    public String toString() {
        return name +
                ":  age=" + age +
                ", sex='" + sex + '\'';
    }
}
