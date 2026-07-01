package com.optimum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupToTarget {
    public static void main(String[] args) {
        int target = 7;
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

        List<List<Integer>> result =
                IntStream.rangeClosed(1, nums.size())   // ANY size
                        .boxed()
                        .flatMap(k -> combinations(nums, k))
                        .filter(list -> list.stream().mapToInt(Integer::intValue).sum() == target)
                        .collect(Collectors.toList());

        System.out.println(result);


         result =
                nums.stream()
                        .<List<List<Integer>>>reduce(
                                List.of(List.of()), // start with empty combination
                                (acc, n) -> Stream.concat(
                                        acc.stream(),
                                        acc.stream().map(list -> {
                                            List<Integer> newList = new ArrayList<>(list);
                                            newList.add(n);
                                            return newList;
                                        })
                                ).collect(Collectors.toList()),
                                (a, b) -> a // combiner (unused for sequential)
                        )
                        .stream()
                        .filter(list -> !list.isEmpty())
                        .filter(list -> list.stream().mapToInt(Integer::intValue).sum() == target)
                        .collect(Collectors.toList());

        System.out.println(result);


        List<List<Integer>> result2 = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        result2.add(current);

        for (int i = 0; i < nums.size(); i++)
        {
           List<Integer> numList = List.of(nums.get(i));
           List<List<Integer>> newCombinations = new ArrayList<>();
           for (List<Integer> combination : result2)
           {
               List<Integer> newCombination = new ArrayList<>(combination);
               newCombination.addAll(numList);
               newCombinations.add(newCombination);
           }
           result2.addAll(newCombinations);
        }

        result2 = result2.stream()
                .filter(list -> !list.isEmpty())
                .filter(list -> list.stream().mapToInt(Integer::intValue).sum() == target)
                .collect(Collectors.toList());

        System.out.println(result2);

    }

    public List<List<Integer>> findCombinations(List<Integer> nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        result.add(current);

        for (int i = 0; i < nums.size(); i++)
        {
            List<Integer> numList = List.of(nums.get(i));
            List<List<Integer>> newCombinations = new ArrayList<>();
            for (List<Integer> combination : result)
            {
                List<Integer> newCombination = new ArrayList<>(combination);
                newCombination.addAll(numList);
                newCombinations.add(newCombination);
            }
            result.addAll(newCombinations);
        }

        result = result.stream()
                .filter(list -> !list.isEmpty())
                .filter(list -> list.stream().mapToInt(Integer::intValue).sum() == target)
                .collect(Collectors.toList());
        return result;
    }

    public static <T> Stream<List<T>> combinations(List<T> list, int k) {
        if (k == 0) {
            return Stream.of(List.of());
        }
        if (list.isEmpty()) {
            return Stream.empty();
        }

        T head = list.get(0);
        List<T> rest = list.subList(1, list.size());

        Stream<List<T>> withHead = combinations(rest, k - 1)
                .map(l -> {
                    List<T> newList = new ArrayList<>();
                    newList.add(head);
                    newList.addAll(l);
                    return newList;
                });

        Stream<List<T>> withoutHead = combinations(rest, k);

        return Stream.concat(withHead, withoutHead);
    }

}
