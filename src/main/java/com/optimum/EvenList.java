package com.optimum;

import java.util.List;

public class EvenList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<String> strings = List.of("10", "abc", "25", "42", "7", "100");

        List<Integer> evenNumbers = strings.stream().filter(s-> s.matches("\\d+")).map(Integer::parseInt).filter(num -> num % 2 == 0).toList();

        System.out.println("Even numbers in the list:");
        for (int num : evenNumbers) {
                System.out.println(num);
        }

        System.out.println("Even numbers in the array:");
        for (int num : arr) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
    }
}
