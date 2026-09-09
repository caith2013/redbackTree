package com.optimum;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {
    public static void main(String[] args) {
        String word1 = "listen";
        String word2 = "silent";

        String sortedWord1 = Stream.of(word1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        String sortedWord2 = Stream.of(word2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        if (sortedWord1.equals(sortedWord2)) {
            System.out.println(word1 + " and " + word2 + " are anagrams.");
        } else {
            System.out.println(word1 + " and " + word2 + " are not anagrams.");
        }

        char[] arr1 = sortedWord1.toCharArray();
        char[] arr2 = sortedWord2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (Arrays.equals(arr1, arr2)) {
            System.out.println(word1 + " and " + word2 + " are anagrams.");
        } else {
            System.out.println(word1 + " and " + word2 + " are not anagrams.");
        }
    }
}
