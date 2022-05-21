package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        LocalDateTime now = item.getCreated();
        String nowFormatted = now.format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"));
        System.out.println(nowFormatted);
        Item second = new Item("Second", 2);
        System.out.println(second);
    }
}
