import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Daniel Bojic
 * Date: 2021-01-19
 * Time: 12:33
 * Project: Inlämningsuppgift 2 Java
 * Copyright: MIT
 */

//    Tomtarna på Nordpolen har en strikt chefs-hierarki:
//    Högsta chefen för allt är "Tomten"
//    Under "Tomten" jobbar "Glader" och "Butter"
//    Under "Glader" jobbar "Tröger", "Trötter" och "Blyger"
//    Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
//    Under "Trötter" jobbar "Skumtomten"
//    Under "Skumtomten" jobbar "Dammråttan"
//    Under "Räven" jobbar "Gråsuggan" och "Myran"
//    Under "Myran" jobbar "Bladlusen"


public class Recursion {
    int x = 0;
    int y = 0;
    List<Person> tomteverkstaden = new ArrayList<>();

    List<Person> tomtensUnderordnade = new ArrayList<>();
    List<Person> gladerUnderordnade = new ArrayList<>();
    List<Person> butterUnderordnade = new ArrayList<>();
    List<Person> trögerUnderordnade = new ArrayList<>();
    List<Person> trötterUnderordnade = new ArrayList<>();
    List<Person> skumtomtenUnderordnade = new ArrayList<>();
    List<Person> dammråttanUnderordnade = new ArrayList<>();
    List<Person> blygerUnderordnade = new ArrayList<>();
    List<Person> rådjuretUnderordnade = new ArrayList<>();
    List<Person> nyckelpiganUnderordnade = new ArrayList<>();
    List<Person> harenUnderordnade = new ArrayList<>();
    List<Person> rävenUnderordnade = new ArrayList<>();
    List<Person> gråsugganUnderordnade = new ArrayList<>();
    List<Person> myranUnderordnade = new ArrayList<>();
    List<Person> bladlusenUnderordnade = new ArrayList<>();


    Recursion() {
        tomteverkstaden.add(tomten);
        tomteverkstaden.add(glader);
        tomteverkstaden.add(butter);
        tomteverkstaden.add(tröger);
        tomteverkstaden.add(trötter);
        tomteverkstaden.add(skumtomten);
        tomteverkstaden.add(dammråttan);
        tomteverkstaden.add(blyger);
        tomteverkstaden.add(rådjuret);
        tomteverkstaden.add(nyckelpigan);
        tomteverkstaden.add(haren);
        tomteverkstaden.add(räven);
        tomteverkstaden.add(gråsuggan);
        tomteverkstaden.add(myran);
        tomteverkstaden.add(bladlusen);


        tomtensUnderordnade.add(glader);
        tomtensUnderordnade.add(butter);

        gladerUnderordnade.add(tröger);
        gladerUnderordnade.add(blyger);

        butterUnderordnade.add(rådjuret);
        butterUnderordnade.add(nyckelpigan);
        butterUnderordnade.add(räven);
        butterUnderordnade.add(haren);

        trötterUnderordnade.add(skumtomten);
        skumtomtenUnderordnade.add(dammråttan);

        rävenUnderordnade.add(myran);
        rävenUnderordnade.add(gråsuggan);

        myranUnderordnade.add(bladlusen);


    }

    Person tomten = new Person("Tomten", tomtensUnderordnade);

    Person glader = new Person("Glader", tomten, gladerUnderordnade);

    Person blyger = new Person("Blyger", glader, blygerUnderordnade);

    Person tröger = new Person("Tröger", glader, trögerUnderordnade);

    Person trötter = new Person("Trötter", glader, trötterUnderordnade);
    Person skumtomten = new Person("Skumtomten", trötter, skumtomtenUnderordnade);
    Person dammråttan = new Person("Dammråttan", skumtomten, dammråttanUnderordnade);


    Person butter = new Person("Butter", tomten, butterUnderordnade);

    Person rådjuret = new Person("Rådjuret", butter, rådjuretUnderordnade);

    Person nyckelpigan = new Person("Nyckelpigan", butter, nyckelpiganUnderordnade);

    Person haren = new Person("Haren", butter, harenUnderordnade);

    Person räven = new Person("Räven", butter, rävenUnderordnade);
    Person gråsuggan = new Person("Gråsuggan", räven, gråsugganUnderordnade);

    Person myran = new Person("Myran", räven, myranUnderordnade);
    Person bladlusen = new Person("Bladlusen", myran, bladlusenUnderordnade);


    public void RecursionMethodUp(String workerName) {
        List<Person> bossList = new ArrayList<>();

        List<Person> personernernenr = new ArrayList<>();

        personernernenr = tomteverkstaden.stream().filter(s -> s.name.equals(workerName)).map(Person::getHigherUp).collect(Collectors.toList());

            if (personernernenr.get(0) != null){
                y++;
                bossList.add(personernernenr.get(0));
                RecursionMethodUp(bossList.get(0).getName());
            }

        if (personernernenr.get(0) != null){
            for (Person person : bossList) {
                System.out.println(person.getName());
            }
        }else if (personernernenr.get(0) == null && y == 0){
            System.out.println("Har ingen chef");
        }

y = 0;

    }

    public void RecursionMethodDown(String workerName) {

        String svar;
        List<Person> underOrdnade = tomteverkstaden.stream().filter(s -> s.getName().equals(workerName)).collect(Collectors.toList());

        if (x == 0){
            if (underOrdnade.get(0).getUnder().size() == 0){
                System.out.println("Ingen jobabar under denna");
            }
        }

        for (int i = 0; i < underOrdnade.size(); i++) {
            for (int j = 0; j < underOrdnade.get(i).under.size(); j++) {

                svar = underOrdnade.get(i).getUnder().get(j).getName();

                System.out.println(svar);

                x++;
                RecursionMethodDown(svar);
            }
        }

x = 0;
    }


}
