package ru.job4j.search;

import java.util.ArrayList;

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
}
