package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(4, 7, x -> 2 * x + 2);
        List<Double> expected = Arrays.asList(10D, 12D, 14D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunction() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(3, 6, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(10D, 17D, 26D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenExponentialFunction() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 4, x -> Math.pow(3, x) + 3);
        List<Double> expected = Arrays.asList(6D, 12D, 30D);
        assertThat(result).containsAll(expected);
    }
}