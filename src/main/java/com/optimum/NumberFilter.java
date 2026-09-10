package com.optimum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class NumberFilter {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<String> strings = Arrays.asList("10", "abc", "25", "42", "7", "100", "xyz", "55", "60", "hello", null);

        System.out.println("Even numbers in the list:");

        System.out.println(filterNumbers(strings, NumberPredicate::isEven));
        System.out.println(filterNumbersExp(strings, NumberPredicate::isEven));

        System.out.println("Odd numbers in the list:");
        System.out.println(filterNumbers(strings, NumberPredicate::isOdd));

        System.out.println("Prime numbers in the list:");
        System.out.println(filterNumbers(strings, NumberPredicate::isPrime));

    }
    public static List<Integer> filterNumbers(List<String> strings, Predicate<Integer> predicate) {
        return strings.stream()
                .filter(s -> s != null && s.matches("\\d+"))
                .map(Integer::parseInt)
                .filter(predicate)
                .toList();
    }

    public static List<Integer> filterNumbersExp(List<String> strings, Predicate<Integer> predicate) {
        return strings.stream()
                .map(NumberFilter::parseInteger)
                .flatMap(Optional::stream)
                .filter(predicate)
                .toList();
    }


    static Optional<Integer> parseInteger(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException | NullPointerException e) {
            return Optional.empty();
        }
    }

    public static class NumberPredicate {
        public static boolean isEven(int number) {
            return number % 2 == 0;
        }

        public static boolean isOdd(int number) {
            return number % 2 != 0;
        }

        public static boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
