package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public Void go() {
        return null;
    }

    @Override
    public Void passenger(int amountPass) {
        return null;
    }

    @Override
    public double fillUp(double amountGas) {
        double costGas = 10;
        return costGas * amountGas;
    }
}
