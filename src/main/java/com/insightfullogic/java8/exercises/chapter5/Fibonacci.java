package com.insightfullogic.java8.exercises.chapter5;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    Map<Integer, Long> cache;

    public Fibonacci() {
        cache = new HashMap<>();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }

    public long fibonacci(int x) {
        return cache.computeIfAbsent(x, i -> fibonacci(i - 1) + fibonacci(i - 2));
        // return Exercises.replaceThisWithSolution();
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.fibonacci(1));
        System.out.println(fibonacci.fibonacci(3));
        System.out.println(fibonacci.fibonacci(4));
        System.out.println(fibonacci.fibonacci(5));
    }
}
