//package org.crazylab.java8.jvm;
//
//public class ClinitTest {
//    static {
//        i = 0;                      // 可以对定义在 static{} 代码块后面的静态变量赋值
//        System.out.println(i);      // 但是无法访问，会提示“非法向前引用”Illegal forward reference
//    }
//    private static int i = 1;       // 定义在 static{} 代码块后面的静态变量
//}
