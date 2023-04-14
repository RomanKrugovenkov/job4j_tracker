package ru.job4j.tracker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        try (PreparedStatement ps = cn.prepareStatement(
                "INSERT INTO items(name, created) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getInt(1));
            }
        }
        return item;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        var items = new ArrayList<Item>();
        try (PreparedStatement ps = cn.prepareStatement(
                "SELECT * FROM items")) {
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                items.add(new Item(
                        rs.getString("name"),
                        rs.getInt("id"),
                        rs.getTimestamp("created").toLocalDateTime()));
            }
        }
        return items;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        boolean rsl = false;
        try (Statement st = cn.createStatement()) {
            if (st.execute(String.format("SELECT * FROM items WHERE id = %d", id))) {
                PreparedStatement ps = cn.prepareStatement(
                        "UPDATE items SET name = ?, created = ? WHERE id = ?");
                ps.setString(1, item.getName());
                ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
                ps.setInt(3, id);
                rsl = !ps.execute();
            }
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rsl = false;
        try (Statement st = cn.createStatement()) {
            if (st.execute(String.format("SELECT * FROM items WHERE id = %d", id))) {
                PreparedStatement ps = cn.prepareStatement(
                        "DELETE FROM items WHERE id = ?");
                ps.setInt(1, id);
                rsl = !ps.execute();
            }
        }
        return rsl;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Item rsl = new Item();
        try (Statement st = cn.createStatement()) {
            if (st.execute(String.format("SELECT * FROM items WHERE id = %d", id))) {
                PreparedStatement ps = cn.prepareStatement(
                        "SELECT * FROM items WHERE id = ?");
                ps.setInt(1, id);
                ResultSet rslSet = ps.executeQuery();
                if (rslSet.next()) {
                    rsl.setId(rslSet.getInt("id"));
                    rsl.setName(rslSet.getString("name"));
                    rsl.setCreated(rslSet.getTimestamp("created").toLocalDateTime());
                }
            }
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        var items = new ArrayList<Item>();
        try (Statement st = cn.createStatement()) {
            st.executeQuery(String.format(
                    "SELECT * FROM items WHERE name LIKE '%%%s%%'", key));
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                items.add(new Item(
                        rs.getString("name"),
                        rs.getInt("id"),
                        rs.getTimestamp("created").toLocalDateTime()));
            }
        }
        return items;
    }
}
