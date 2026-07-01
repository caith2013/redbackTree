package com.optimum;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 8, 1};
        int secondLargest = findSecondLargest(arr);
        System.out.println("The second largest number is: " + secondLargest);

        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(second -> {
            System.out.println("The second largest number using streams is: " + second);
        });

        Arrays.stream(arr).boxed().filter(num -> num % 5 ==0).forEach(System.out::println);
    }

    public static int findSecondLargest(int[] arr) {
        int largest = arr[0];
        int secondLargest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
}
