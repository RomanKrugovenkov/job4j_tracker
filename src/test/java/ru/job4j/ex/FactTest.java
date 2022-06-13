package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNlessZerro() {
        Fact.calc(-1);
    }

    @Test
    public void when3then6() {
        int rsl = Fact.calc(3);
        assertEquals(rsl, 6);
    }
}