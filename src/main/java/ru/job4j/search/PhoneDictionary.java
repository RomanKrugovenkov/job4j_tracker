package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> rst = new ArrayList<>();
        for (Person p : persons) {
            if (key.equals(p.getAddress()) || key.equals(p.getPhone())
                    || key.equals(p.getSurname()) || key.equals(p.getName())) {
                rst.add(p);
            }
        }
        return rst;
    }

    public ArrayList<Person> find2(String key) {
        Predicate<Person> eqlAddress = p -> key.equals(p.getAddress());
        Predicate<Person> eqlPhone = p -> key.equals(p.getPhone());
        Predicate<Person> eqlSurname = p -> key.equals(p.getSurname());
        Predicate<Person> eqlName = p -> key.equals(p.getName());
        Predicate<Person> combine = eqlAddress.or(eqlPhone).or(eqlSurname).or(eqlName);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
