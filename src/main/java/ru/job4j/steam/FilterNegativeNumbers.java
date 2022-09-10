package ru.job4j.steam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, -2, -5, 6, 8);
        List<Integer> positive = numbers.stream().filter(n -> n > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
