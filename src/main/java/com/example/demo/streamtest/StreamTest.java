package com.example.demo.streamtest;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/6/13 10:09
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics intSummaryStatistics=numbers.stream().mapToInt(i->i).summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getSum());
    }
}
