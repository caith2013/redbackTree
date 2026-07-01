package com.optimum;

import java.util.Arrays;
import java.util.List;

public class CommonElements
{
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("this", "is", "a", "string");
        List<String> list2 = Arrays.asList("this", "is", "another", "string");

        List<String> list3 = Arrays.asList("this", "is", "duplicate", "string", "string");

        list1.stream().filter(list2::contains).forEach(System.out::println);

        list3.stream().distinct().toList().forEach(System.out::println);

    }

}
