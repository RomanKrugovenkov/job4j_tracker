package ru.job4j.steam;

import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(s -> Stream.of(Value.values())
                        .map(v -> new Card(s, v)))
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Card{" + "suit=" + suit + ", value=" + value + '}';
    }
}
