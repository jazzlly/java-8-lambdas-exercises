package com.insightfullogic.java8.examples.chapter2;

/**
 * Created by ryanjiang on 2017/5/12.
 */
@FunctionalInterface
public interface MyPredicate<T> {
    boolean come(T t);
}
