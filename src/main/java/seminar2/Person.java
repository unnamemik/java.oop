package seminar2;


import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
@Getter
@Setter
public class Person {
    private int age;
    private String name;
    private String sex;
    private int gen = 1;

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

    @Override
    public String toString() {
        return name +
                ":  age=" + age +
                ", sex='" + sex + '\'';
    }
}
