package com.optimum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ShiftNumber
{
    public static void main(String[] args)
    {
        int[] numbers1 = {5, 10, 15, 20, 7};
        int[] numbers2 = {1, 3, 0, 9, 6};

        ArrayList<Integer> result = new ArrayList<>();

        for (int i=0; i < numbers1.length; i++)
        {
            LinkedList<Integer> list1 = new LinkedList<>(Arrays.stream(numbers1).boxed().toList());
            int sum = 0;
            for (int j=0; j < i; j++)
            {
                int last = list1.removeLast();
                list1.addFirst(last);
            }
            for (int k =0; k < numbers2.length; k++)
            {
                sum += Math.abs(list1.get(k) - numbers2[k]);
            }
            result.add(sum);
        }
        System.out.println(result);

        List<Integer> result1 = IntStream.range(0, numbers1.length)
                .mapToObj(i ->{
                    List<Integer> rotated = IntStream.range(0,numbers1.length).map(j -> numbers1[(j + numbers1.length - i) % numbers1.length]).boxed().toList();
                    return IntStream.range(0, numbers2.length).map(k -> Math.abs(rotated.get(k) - numbers2[k])).sum();
                })
                .toList();
        System.out.println(result1);

    }
}
