package com.optimum;

import java.util.*;
import java.util.function.*;

public class NumFilter
{
    List<String> inputList = Arrays.asList("1", "2", "3", "4", "7", "11", "9", "37", "12as", null, "abs", "59", "127", "165");

            List<Integer> evenNumbers = inputList.stream()
                    .filter(Objects::nonNull)
                    .filter(s -> s.matches("\\d+"))
                    .map(Integer::parseInt)
                    .filter(n -> n % 2 == 0)
                    .toList();

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

    public static Optional<Integer> parseInt(String s)
    {
        try
        {
           return Optional.of(Integer.parseInt(s));
        }
        catch (NullPointerException | NumberFormatException e)
        {
            return Optional.empty();
        }
    }

    public List<Integer> filterNumbers(List<String> inputList, Predicate<Integer> predicate)
    {
        return inputList.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt)
                .filter(predicate)
                .toList();

    }

    public List<Integer> filterNumbersException(List<String> inputList, Predicate<Integer> predicate)
    {
        return inputList.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.matches("\\d+"))
                .map(NumFilter::parseInt)
                .flatMap(Optional::stream)
                .filter(predicate)
                .toList();

    }

    public static void main(String[] args)
    {
        NumFilter numFilter = new NumFilter();

        List<Integer> evenNumbers = numFilter.filterNumbers(numFilter.inputList, NumFilter.isEven);
        System.out.println("Even number list:");
        System.out.println(evenNumbers);

        List<Integer> oddNumbers = numFilter.filterNumbers(numFilter.inputList, NumFilter.isOdd);
        System.out.println("Odd number list:");
        System.out.println(oddNumbers);

        List<Integer> primeNumbers = numFilter.filterNumbers(numFilter.inputList, NumFilter.isPrime);
        System.out.println("Prime number list:");
        System.out.println(primeNumbers);

        primeNumbers = numFilter.filterNumbersException(numFilter.inputList, NumFilter.isPrime);
        System.out.println("Prime number list:");
        System.out.println(primeNumbers);
    }
}