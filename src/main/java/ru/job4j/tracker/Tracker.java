package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int count = 0;
        Item[] rst = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                rst[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(rst, count);
    }

    public Item[] findByName(String key) {
        int count = 0;
        Item[] rst = new Item[size];
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                rst[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(rst, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        item.setId(items[index].getId());
        items[index] = item;
        return index != -1;
    }
}