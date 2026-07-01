package com.optimum;

import java.util.stream.IntStream;

public class Palindrome {
    public static void main(String[] args) {
        String str = "AmanaplanacanalPanama";

        IntStream.range(0, str.length() / 2)
                .filter(i -> Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(str.length() - 1 - i)))
                .findFirst()
                .ifPresentOrElse(
                        i -> System.out.println("Not a palindrome"),
                        () -> System.out.println("Palindrome")
                );

        boolean isPalindrome = IntStream.range(0, str.length() / 2).noneMatch(i -> Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(str.length() - 1 - i)));
        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}
