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
        int size = 0;
        Item[] rst = new Item[this.size];
        for (int i = 0; i < this.size; i++) {
            if (items[i] != null) {
                rst[size] = items[i];
                size++;
            }
        }
        rst = Arrays.copyOf(rst, size);
        for (Item r : rst) {
            System.out.println(r);
        }
        return rst;
    }

    public Item[] findByName(String key) {
        int size = 0;
        Item[] rst = new Item[this.size];
        for (int i = 0; i < this.size; i++) {
            if (key.equals(items[i].getName())) {
                rst[size] = items[i];
                size++;
            }
        }
        rst = Arrays.copyOf(rst, size);
        for (Item r : rst) {
            System.out.println(r);
        }
        return rst;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}