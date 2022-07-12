package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class JobTest {
    @Test
    public void whenSortJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("CDE", 7),
                new Job("BCD", 5),
                new Job("ABC", 3)
        );
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("ABC", 3),
                new Job("BCD", 5),
                new Job("CDE", 7)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenSortJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("BCD", 5),
                new Job("CDE", 7),
                new Job("ABC", 3)
        );
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("CDE", 7),
                new Job("BCD", 5),
                new Job("ABC", 3)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenSortJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("BCD", 5),
                new Job("CDE", 4),
                new Job("ABC", 3)
        );
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("ABC", 3),
                new Job("CDE", 4),
                new Job("BCD", 5)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenSortJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("CDE", 4),
                new Job("BCD", 5),
                new Job("ABC", 3)
        );
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("BCD", 5),
                new Job("CDE", 4),
                new Job("ABC", 3)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenSortJobAscByNameAndPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("CDE", 7),
                new Job("BCD", 5),
                new Job("BCD", 4),
                new Job("ABC", 3)
        );
        Comparator<Job> comb = new JobAscByName().thenComparing(new JobAscByPriority());
        jobs.sort(comb);
        List<Job> expected = Arrays.asList(
                new Job("ABC", 3),
                new Job("BCD", 4),
                new Job("BCD", 5),
                new Job("CDE", 7)
        );
        assertEquals(expected, jobs);
    }

    @Test
    public void whenSortJobDescByPriorityAndName() {
        List<Job> jobs = Arrays.asList(
                new Job("BCD", 4),
                new Job("BCD", 5),
                new Job("CDE", 7),
                new Job("ABC", 4)
        );
        Comparator<Job> comb = new JobDescByPriority().thenComparing(new JobDescByName());
        jobs.sort(comb);
        List<Job> expected = Arrays.asList(
                new Job("CDE", 7),
                new Job("BCD", 5),
                new Job("BCD", 4),
                new Job("ABC", 4)
        );
        assertEquals(expected, jobs);
    }
}