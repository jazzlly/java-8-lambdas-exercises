package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 1
 */
public class FilterUsingReduce {

    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> list = new ArrayList<>();
        stream.reduce((acc, element) -> {
            if (predicate.test(element)) {
                list.add(element);
            }
            return element;
        });
        return list;
        // return Exercises.replaceThisWithSolution();
    }

    public static void main(String[] args) {
        System.out.println(
                FilterUsingReduce.filter(
                        Stream.of(1, 2, 3, 9, 8),
                        integer -> integer >= 3).toString()
        );


    }

}
