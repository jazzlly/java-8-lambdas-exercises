package com.insightfullogic.java8.examples.chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jiangrui on 17/7/2.
 */
public class RyanDemo {
    public static void main(String[] args) {

        List<Integer> integerList = Stream.of(1, 2, 3).collect(Collectors.toList());
        Consumer<Integer> integerConsumer = integer -> System.out.println(integer);
        Consumer<Number> numberConsumer = number -> System.out.println(number);

        integerList.forEach(integerConsumer);
        integerList.forEach(numberConsumer);

        List<Number> numberList = Stream.of(1, 2.5, 3l, 4d).collect(Collectors.toList());
        numberList.forEach(numberConsumer);
        // numberList.forEach(integerConsumer); // compile error
    }

}
