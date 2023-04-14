package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class SingleTracker {
    private static SingleTracker instance = null;
    private Store tracker;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) throws SQLException {
        return tracker.add(item);
    }

    public List<Item> findAll() throws SQLException {
        return tracker.findAll();
    }

    public List<Item> findByName(String key) throws SQLException {
        return tracker.findByName(key);
    }

    public Item findById(int id) throws SQLException {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) throws SQLException {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) throws SQLException {
        return tracker.delete(id);
    }
}
