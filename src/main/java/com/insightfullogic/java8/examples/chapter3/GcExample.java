package com.insightfullogic.java8.examples.chapter3;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;

/**
 * Created by ryanjiang on 2017/5/27.
 */
public class GcExample {
    public static void main(String[] args) throws InterruptedException {

        Person p = new Person();
        p.setId(1);
        p.setName("zhaosi");
        p.setAge(17);
        System.out.println(p);
        ReferenceQueue<Person> queue = new ReferenceQueue<Person>();
        PhantomReference<Person> phaRef = new PhantomReference<Person>(p, queue);

        p = null;
        System.gc();

        while (true) {
            Object o = queue.poll();
            if (o != null) {
                try {
                    Field rereferent = Reference.class
                            .getDeclaredField("referent");
                    rereferent.setAccessible(true);
                    Person result = (Person)rereferent.get(o);
                    System.out.println("system gc will kill person:" +result.getName());
                    System.out.println(result);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("sleep some time!");
                Thread.sleep(2000);
            }
        }
    }
}
