package org.crazylab.java8.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class WeakReferenceDemo01 {

    public static void main(String[] args) {
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        // 直接使用字面量声明一个 String 对象，编译器产生的class文件中会声明123这个字面量，然后放入常量池中，在常量池
        // 中保存的就是123字面量的一个引用，这个引用不会被 gc 回收
//        String ss = "123";
        // 通过 new 构建的 String 实例，在堆中实例化一个对象，并把该对象的引用赋值给 ss，当执行 ss = null 后，就会被 gc 检查到
        // 并回收
        String ss = new String("123");
        WeakReference<String> reference = new WeakReference<>(ss.intern(), queue);
        Object x = queue.poll();
        System.out.println("before gc queue.poll " + x);
        System.out.println("before gc reference.get " + reference.get());

        // 删除引用，并手动 gc
        ss = null;
        System.gc();

        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    Object y = queue.poll();
                    System.out.println("after gc queue.poll " + y);
                    System.out.println("after gc reference.get " + reference.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
