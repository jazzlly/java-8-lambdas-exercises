package com.insightfullogic.java8.examples.chapter4;

// public class Child2Impl implements Child, Child2 {
public class Child2Impl implements Child{

    public static void main(String[] args) {
        Child2Impl child2 = new Child2Impl();
        child2.welcome();
    }

    @Override
    public void message(String body) {
    }

    @Override
    public String getLastMessage() {
        return null;
    }
}
