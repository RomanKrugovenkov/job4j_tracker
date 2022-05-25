package ru.job4j.poly;

public interface Transport {
    void go();

    void passenger(int amountPass);

    double fillUp(double amountGas);
}
