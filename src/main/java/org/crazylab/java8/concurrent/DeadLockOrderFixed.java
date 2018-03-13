package org.crazylab.java8.concurrent;

import java.util.concurrent.TimeUnit;

public class DeadLockOrderFixed {

    public void method1() {
        synchronized (Integer.class) {
            System.out.println(Thread.currentThread() + " Aquired lock on Integer.class object");
            synchronized (String.class) {
                System.out.println(Thread.currentThread() + " Aquired lock on String.class object");
            }
        }
    }

    public void method2() {
        synchronized (Integer.class) {
            System.out.println(Thread.currentThread() + " Aquired lock on Integer.class object");
            synchronized (String.class) {
                System.out.println(Thread.currentThread() + " Aquired lock on String.class object");
            }
        }
    }

    public static void main(String[] args) {
        DeadLockOrderFixed bean = new DeadLockOrderFixed();
        Runnable runner1 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MICROSECONDS.sleep(5);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    bean.method1();
                }
            }
        };

        Runnable runner2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MICROSECONDS.sleep(8);
                        bean.method2();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(runner1).start();
        new Thread(runner2).start();

        try {
            Thread.sleep(40000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
