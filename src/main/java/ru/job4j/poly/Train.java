package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Катит по рельсам");
    }

    @Override
    public double speed() {
        return 200;
    }
}
