package ru.job4j.function;

import java.util.Comparator;
import java.util.Arrays;

public class LengthCmp {
    public static void main(String[] args) {
        String[] names1 = {
                "Ivan",
        };
        Comparator<String> lengthCmp1 = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names1, lengthCmp1);
        String[] names2 = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp2 = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names2, lengthCmp2);
    }
}
