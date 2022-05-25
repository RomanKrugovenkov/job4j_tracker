package ru.job4j.poly;

public class Buses implements Vehicle {
    @Override
    public void move() {
        System.out.println("Едет по дороге");
    }

    @Override
    public double speed() {
        return 100;
    }
}
