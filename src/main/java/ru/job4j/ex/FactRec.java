package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        int rst = 0;
        if (n == 0 || n == 1) {
            rst = 1;
        } else {
            rst = calc(n - 1) * n;
        }
        return rst;
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}
