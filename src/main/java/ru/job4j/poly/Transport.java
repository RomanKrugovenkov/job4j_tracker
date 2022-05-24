package ru.job4j.poly;

public interface Transport {
    Void go();

    Void passenger(int amountPass);

    double fillUp(double amountGas);
}
