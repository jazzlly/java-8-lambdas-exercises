package com.insightfullogic.java8.examples.chapter2;

import java.awt.event.ActionListener;
import java.util.function.*;

public class RyanExample {

    public boolean check(Predicate<Integer> predicate, int a) {
        return predicate.test(a);
    }

    // fixme: 这里取消注释会报错, 和上面check冲突
//    public boolean check(IntPredicate predicate, int a) {
//        return predicate.test(a);
//    }

    public static void main(String[] args) throws InterruptedException {
        RyanExample example = new RyanExample();
        System.out.println(example.check(x -> x > 10, 20));

        // fixme: runnable的简化
        {
            String name = "1234"; // 既成事实的final
            // final String name = "1234";
            // name = "234"; // fixme: name只能被赋值一次, 这里会报错
            Thread thread = new Thread(() -> {
                System.out.println("run run lambda!");
                System.out.println(name);
            });
            thread.start();
            thread.join();

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("run run lambda");
//            }
//        };

//        Runnable runnable = () -> {
//            System.out.println("run run lambda!");
//        };

        }

        ActionListener actionListener  = (event) -> {
            System.out.println(event.toString());
        };

//        BinaryOperator<Long> add = new BinaryOperator<Long>() {
//            @Override
//            public Long apply(Long aLong, Long aLong2) {
//                return aLong + aLong2;
//            }
//        };

        BinaryOperator<Long> add = (x, y) -> x + y;
        System.out.println(add.apply(20l, 30l));


        BinaryOperator<Long> add1 = (x, y) -> { return x + y; };

        MyPredicate<Long> myPredicate = (x) -> x % 2 == 0;

        Predicate<Long> predicate = (x) -> x % 2 == 0;
        System.out.println(predicate.test(20l));


        Consumer<Integer> consumer = (x) -> System.out.println(x);
        consumer.accept(30);


        Function<String, Integer> function = (str) -> Integer.parseInt(str);
        System.out.println(function.apply("234"));


        Supplier<String> supplier = () -> "test";
        System.out.println(supplier.get());

        UnaryOperator<String> unaryOperator = (s) -> s.replace(" ", "");
        System.out.println(unaryOperator.apply("hello world!"));

    }


}
