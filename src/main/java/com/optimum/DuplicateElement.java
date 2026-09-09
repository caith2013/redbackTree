package com.optimum;

import java.util.HashMap;
import java.util.Map;

public class DuplicateElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 6, 7, 8, 9,
                10,6,6};
        System.out.println("Duplicate elements in the array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[j]);
                }
            }
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            Integer count = countMap.get(num);
            if (count == null) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, count + 1);
                System.out.println(num + " is a duplicate element.");
            }
        }

        DuplicateElement.reverseArray(arr, 0, arr.length - 1);
        System.out.println("Reversed array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void reverseArray(int[] arr, int start, int end) {
        if  (start >= end) {
            return;
        }
        else
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseArray(arr, start + 1, end - 1);
        }

    }
}