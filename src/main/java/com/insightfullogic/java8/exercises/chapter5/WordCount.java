package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WordCount {

    public static Map<String, Long> countWords(Stream<String> names) {
        return names.collect(groupingBy(s -> s, counting()));
        //return Exercises.replaceThisWithSolution();
    }

    public static void main(String[] args) {
        Map<String, Long> map = WordCount.countWords(
                Stream.of("ray", "jiang", "ray", "tom", "ray", "jiang"));
        System.out.println(map.toString());
    }
}
