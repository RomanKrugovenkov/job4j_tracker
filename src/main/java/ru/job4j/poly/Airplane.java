package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Летает везде");
    }

    @Override
    public double speed() {
        return 800;
    }
}
