package ru.job4j.steam;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        BiPredicate<Integer, Integer> diffMore0 = (s, a) -> s - a >= 0;
        BiPredicate<Integer, Integer> diffLess3 = (s, a) -> s - a <= 3;
        return products.stream()
                .filter(p -> diffMore0.test(p.getStandard(), p.getActual()))
                .filter(p -> diffLess3.test(p.getStandard(), p.getActual()))
                .map(p -> new Label(p.getName(), p.getPrice() / 2))
                .map(Label::toString)
                .collect(Collectors.toList());
    }
}
