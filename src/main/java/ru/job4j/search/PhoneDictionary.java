package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var rst = new ArrayList<Person>();
        for (var p : persons) {
            if (key.equals(p.getAddress()) || key.equals(p.getPhone())
                    || key.equals(p.getSurname()) || key.equals(p.getName())) {
                rst.add(p);
            }
        }
        return rst;
    }

    public ArrayList<Person> find2(String key) {
        Predicate<Person> eqlAddress = p -> p.getAddress().contains(key);
        Predicate<Person> eqlPhone = p -> p.getPhone().contains(key);
        Predicate<Person> eqlSurname = p -> p.getSurname().contains(key);
        Predicate<Person> eqlName = p -> p.getName().contains(key);
        Predicate<Person> combine = eqlAddress.or(eqlPhone).or(eqlSurname).or(eqlName);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
