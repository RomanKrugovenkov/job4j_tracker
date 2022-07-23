package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double summ = 0;
        int amount = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                summ += subject.score();
                amount++;
            }
        }
        return summ / amount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double summ = 0;
            for (Subject subject : pupil.subjects()) {
                summ += subject.score();
            }
            rsl.add(new Label(pupil.name(), summ / pupil.subjects().size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temps = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temps.computeIfPresent(subject.name(), (a, b) -> b = subject.score() + temps.get(subject.name()));
                temps.putIfAbsent(subject.name(), subject.score());
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (String key : temps.keySet()) {
            rsl.add(new Label(key, temps.get(key) / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double summ = 0;
            for (Subject subject : pupil.subjects()) {
                summ += subject.score();
            }
            rsl.add(new Label(pupil.name(), summ));
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temps = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temps.computeIfPresent(subject.name(), (a, b) -> b = subject.score() + temps.get(subject.name()));
                temps.putIfAbsent(subject.name(), subject.score());
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (String key : temps.keySet()) {
            rsl.add(new Label(key, temps.get(key)));
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }
}
