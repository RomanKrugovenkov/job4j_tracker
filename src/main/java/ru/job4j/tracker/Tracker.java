package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> rst = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                rst.add(item);
            }
        }
        return rst;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (id == item.getId()) {
                rsl = items.indexOf(item);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rst = index != -1;
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
        }
        return rst;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rst = index != -1;
        if (index != -1) {
            items.remove(index);
        }
        return rst;
    }
}
