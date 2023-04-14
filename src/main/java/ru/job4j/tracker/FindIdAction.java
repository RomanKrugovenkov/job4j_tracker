package ru.job4j.tracker;

import java.sql.SQLException;

public class FindIdAction implements UserAction {
    private final Output out;

    public FindIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws SQLException {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter Id: ");
        Item temp = tracker.findById(id);
        if (temp != null) {
            out.println(temp);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
