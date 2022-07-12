package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int size = Math.max(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            int temp = 0;
            if (i < left.length() && i < right.length()) {
                temp = Character.compare(left.charAt(i), right.charAt(i));
            } else if (i >= left.length()) {
                temp = -1;
            } else {
                temp = 1;
            }
            rsl += temp;
        }
        return rsl;
    }
}
