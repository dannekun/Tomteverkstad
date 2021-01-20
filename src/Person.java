import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Bojic
 * Date: 2021-01-19
 * Time: 12:31
 * Project: Inlämningsuppgift 2 Java
 * Copyright: MIT
 */
public class Person {
    String name;
    Person higherUp = null;
    List<Person> under;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getHigherUp() {
        return higherUp;
    }

    public void setHigherUp(Person higherUp) {
        this.higherUp = higherUp;
    }

    public List<Person> getUnder() {
        return under;
    }

    public void setUnder(List<Person> under) {
        this.under = under;
    }

    Person(){}

    Person(String name, List<Person> undersåtare){
        this.name = name;
        under = undersåtare;
    }

    Person(String name, Person chef, List<Person> undersåtare){
        this.name = name;
        higherUp = chef;
        under = undersåtare;

    }
}
