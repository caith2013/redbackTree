package com.optimum;

import java.util.Arrays;
import java.util.Comparator;

public class SortListInReverseOrder {
    public static void main(String[] args) {
      int[] arr = {1,3,5,7,9};
        Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder()) // Sort in reverse order
                .forEach(System.out::println);


    }
}
