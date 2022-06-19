package ru.job4j.ooa;

public class Airbus {
    private static int countEngine = 2;
    private static String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        countEngine = name == "A380" ? 4 : 2;
        System.out.println("Количество двигателей равно: " + countEngine);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
