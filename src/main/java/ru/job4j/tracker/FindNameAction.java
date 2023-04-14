package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class FindNameAction implements UserAction {
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> temp = tracker.findByName(name);
        if (temp.size() > 0) {
            for (Item item : temp) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
