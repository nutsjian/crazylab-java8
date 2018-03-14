package org.crazylab.java8.constantpool;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class InternDemo01 {
    public static void main(String[] args) {
        String s = "1234";
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        String ss = new String("123");
        WeakReference<String> reference = new WeakReference<>(ss, queue);
        Object x = queue.poll();
        System.out.println("1before gc queue.poll " + x);
        System.out.println("1before gc reference.get " + reference.get());

        // 删除引用，并手动 gc
//        ss = null;
        System.out.println(s == ss);
        ss = ss.intern();
//        ss = ss.intern();
        System.out.println(s == ss);

        System.gc();

        try {
            TimeUnit.MICROSECONDS.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object y = queue.poll();
        System.out.println("1after gc queue.poll " + y);
        System.out.println("1after gc reference.get " + reference.get());

//        new Thread(() -> {
//            while (true) {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                    Object y = queue.poll();
//                    System.out.println("1after gc queue.poll " + y);
//                    System.out.println("1after gc reference.get " + reference.get());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }
}
