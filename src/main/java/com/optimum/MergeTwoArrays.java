package com.optimum;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        Arrays.stream(IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .sorted().toArray()).distinct().forEach(System.out::println);


    }
}
