package com.optimum;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigits {
    public static void main(String[] args) {
        int number = 12345; // Example number
        int sum = sumOfDigits(number);
        System.out.println("The sum of all digits in " + number + " is: " + sum);

        int streamSum = Stream.of(String.valueOf(number).split(""))
                              .mapToInt(Integer::parseInt)
                              .sum();
        System.out.println("The sum of all digits using streams in " + number + " is: " + streamSum);

        streamSum = Stream.of(String.valueOf(number).split("")).collect(Collectors.summingInt(Integer::parseInt));

        System.out.println("The sum of all digits using streams in " + number + " is: " + streamSum);
    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
