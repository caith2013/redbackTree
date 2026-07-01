package com.optimum;

import java.util.Arrays;
import java.util.Comparator;

public class MaxAndMin {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 8, 2};
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);



        Arrays.stream(arr).sorted().limit(3).forEach(System.out::println);
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
    }
}
