package com.optimum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        int [] mergedArray = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .sorted()
                .distinct()
                .toArray();

        Arrays.stream(mergedArray).forEach(System.out::println);

        Arrays.stream(IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .sorted().toArray()).distinct().forEach(System.out::println);

        Set<Integer> numSet = new HashSet<>();
        numSet.addAll(Arrays.stream(nums1).boxed().collect(Collectors.toSet()));
        numSet.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toSet()));
        numSet.forEach(System.out::println);



    }
}
