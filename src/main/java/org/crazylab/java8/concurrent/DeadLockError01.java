package org.crazylab.java8.concurrent;

import java.util.concurrent.TimeUnit;

public class DeadLockError01 {
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    public void method1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread() + " Aquired lock on Integer.class object");
            try {
                TimeUnit.MICROSECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (lock2) {
                System.out.println(Thread.currentThread() + " Aquired lock on String.class object");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread() + " Aquired lock on Integer.class object");
            try {
                TimeUnit.MICROSECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
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
                        TimeUnit.MICROSECONDS.sleep(6);
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
                        TimeUnit.MICROSECONDS.sleep(7);
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
