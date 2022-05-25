package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Поедем на автобусе");
    }

    @Override
    public void passenger(int amountPass) {
        System.out.println("В автобусе едет " + amountPass + " пассажиров");
    }

    @Override
    public double fillUp(double amountGas) {
        double costGas = 10;
        return costGas * amountGas;
    }
}
