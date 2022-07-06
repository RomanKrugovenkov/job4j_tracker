package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    @Test
    public void whenSortItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Three", 3),
                new Item("Two", 2),
                new Item("One", 1)
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("One", 1),
                new Item("Three", 3),
                new Item("Two", 2)
        );
        assertEquals(expected, items);
    }

    @Test
    public void whenSortItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Three", 3),
                new Item("Two", 2),
                new Item("One", 1)
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Two", 2),
                new Item("Three", 3),
                new Item("One", 1)
        );
        assertEquals(expected, items);
    }
}