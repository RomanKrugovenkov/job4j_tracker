package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
            connection.createStatement().execute(
                    "CREATE TABLE IF NOT EXISTS items (id serial primary key, name text, created timestamp);"
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() throws SQLException {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenAdd2itemsAndFindAll() throws SQLException {
        Store tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        List<Item> items = new ArrayList<>(List.of(item1, item2));
        assertThat(tracker.findAll()).isEqualTo(items);
    }

    @Test
    public void whenReplaceItem() throws SQLException {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item1");
        Item itemReplace = new Item("item111");
        tracker.add(item);
        tracker.replace(item.getId(), itemReplace);
        assertThat(tracker.findById(item.getId())).isEqualTo(itemReplace);
    }

    @Test
    public void whenAdd2itemsAndDel1() throws SQLException {
        Store tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item2.getId());
        List<Item> items = new ArrayList<>(List.of(item1));
        assertThat(tracker.findAll()).isEqualTo(items);
    }

    @Test
    public void whenFindIdEqualsItem2() throws SQLException {
        Store tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item2.getId())).isEqualTo(item2);
    }

    @Test
    public void whenFindByName11() throws SQLException {
        Store tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item11");
        Item item3 = new Item("item1122");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> items = new ArrayList<>(List.of(item2, item3));
        assertThat(tracker.findByName("11")).isEqualTo(items);
    }
}