package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ===");
                int id = input.askInt("Enter Id: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка изменена успешно.");
                } else {
                    System.out.println("Ошибка замены заявки.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ===");
                int id = input.askInt("Enter Id: ");
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена успешно.");
                } else {
                    System.out.println("Ошибка удаления заявки.");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                int id = input.askInt("Enter Id: ");
                Item temp = tracker.findById(id);
                if (temp != null) {
                    System.out.println(temp);
                } else {
                    System.out.println("Заявка с введенным id: " + id + " не найдена.");
                }
            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                String name = input.askStr("Enter name: ");
                Item[] temp = tracker.findByName(name);
                if (temp.length > 0) {
                    for (Item item : temp) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с именем: " + name + " не найдены.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }
}