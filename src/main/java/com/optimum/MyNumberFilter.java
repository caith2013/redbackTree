package com.optimum;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class MyNumberFilter
{
    List<String> inputList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10","45","37","12d","abc",null);

    public static void main(String[] args) {
        MyNumberFilter myNumberFilter = new MyNumberFilter();
        List<Integer> evenNumberList = myNumberFilter.filterEvenNumbers(myNumberFilter.inputList);
        System.out.println(evenNumberList);

        List<Integer> oddNumberList = myNumberFilter.filterNumbers(myNumberFilter.inputList, isOdd);
        System.out.println(oddNumberList);

        List<Integer> primeNumberList = myNumberFilter.filterNumbers(myNumberFilter.inputList, isPrime);
        System.out.println(primeNumberList);
    }
    public List<Integer> filterEvenNumbers(List<String> inputList) {
        return inputList.stream()
            .filter(Objects::nonNull)
            .filter(s -> s.matches("\\d+"))
            .map(Integer::parseInt)
            .filter(n -> n % 2 == 0)
            .toList();
    }

    public static final Predicate<Integer> isEven = n -> n % 2 == 0;
    public static final Predicate<Integer> isOdd = n -> n % 2 != 0;
    public static final Predicate<Integer> isPrime = n -> {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) return false;
        }
        return true;
    };
    public List<Integer> filterNumbers(List<String> inputList, Predicate<Integer> predicate) {
        return inputList.stream()
            .filter(Objects::nonNull)
            .filter(s -> s.matches("\\d+"))
            .map(MyNumberFilter::parseInteger).flatMap(Optional::stream)
            .filter(predicate)
            .toList();
    }

    public static Optional<Integer> parseInteger(String n)
    {
        try
        {
            return Optional.of(Integer.parseInt(n));
        }
        catch (NumberFormatException | NullPointerException e)
        {
            return Optional.empty();
        }
    }
}
