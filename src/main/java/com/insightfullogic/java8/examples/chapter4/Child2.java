package com.insightfullogic.java8.examples.chapter4;

// BEGIN body
public interface Child2 extends Parent {

    @Override
    public default void welcome() {
        message("Child2: Hi!");
    }
}
// END body
