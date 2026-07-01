package com.optimum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class OddAndEven
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("case one:");

        Arrays.stream(arr).forEach(num -> {
            if (num % 2 == 0) {
                System.out.println(num + " is even.");
            } else {
                System.out.println(num + " is odd.");
            }
        });

        System.out.println("case two:");
        ArrayList<Integer> evenNumbers = Arrays.stream(arr)
                .filter(num -> num % 2 == 0)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("case three:");
        Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(num -> num % 2 == 0)).forEach((isEven, numbers) -> {
            String type = isEven ? "even" : "odd";
            numbers.forEach(num -> System.out.println(num + " is " + type + "."));
        });

        System.out.println("case four:");
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0)
            {
                System.out.println(arr[i] + " is even.");
            }
            else
            {
                System.out.println(arr[i] + " is odd.");
            }
        }
    }
}
