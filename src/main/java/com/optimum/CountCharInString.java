package com.optimum;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharInString {

    public static void main(String[] args)
    {
        String inputString = "this is a string";
        inputString.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
            .entrySet().stream()
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        inputString.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        Map<Character, Long> charCountMap = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0L) + 1);
        }
        charCountMap.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }


}
