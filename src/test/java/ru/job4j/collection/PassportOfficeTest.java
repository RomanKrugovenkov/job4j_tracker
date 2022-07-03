package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addFalse() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen oldCitizen = new Citizen("2f44a", "Ivan Petrov");
        PassportOffice office = new PassportOffice();
        office.add(oldCitizen);
        office.add(citizen);
        assertThat(office.add(citizen), is(false));
    }
}