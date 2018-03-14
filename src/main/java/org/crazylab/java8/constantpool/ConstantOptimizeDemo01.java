package org.crazylab.java8.constantpool;

public class ConstantOptimizeDemo01 {
    public static void main(String[] args) {
        String s0 = "abc";
        String s1 = "a" + "bc";     // 编译器会优化成 s1 = "abc"，在生成的字节码中，根本看不到"a"、"bc" 这两个东西
        String s2 = "ab" + "c";     // 同样会被编译器优化成 s2 = "abc"
        // 以上两种编译器优化的具体实现是由一种叫做“常量折叠”的优化技术实现的
        // 那么常量折叠需要有什么条件呢？
        // 1. 必须是编译期常量之间进行运算才会进行常量折叠
        // 2. 什么是“编译期常量”？是指“编译的时候就可以确定其值的常量”，举几个例子
        //      2.1 字面量，如数字字面量，字符串字面量（1、2、3、100、"a"、"xyz"）等
        //      2.2 编译期常量进行简单运算后的结果也是编译期常量，如（1+2）结果是3，（"x"+"yz"）结果是"xyz"
        //      2.3 被编译器常量赋值 final 的基本类型和字符串变量，如（final int a = 1，final String a = "xy"）
        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
        System.out.println(s1 == s2);

        String x0 = "xyz";
        String x1 = "xy";
        String x2 = "z";
        String x3 = "xy" + "z";
        String x4 = x1 + x2;        // 两个非 final 的变量相加，所以不会进行常量折叠，而是根据String类特有的 + 运算符重载，变成类似这样的代码
        //  String x4 = new StringBuffer(x1).append(x2).toString(); 这里 toString() 会生成新的 String 变量。
        System.out.println(x0 == x3);
        System.out.println(x3 == x4);

        String ss = "abc";
        final String ssa = "a";
        final String ssbc = "bc";
//        String ss1 = ssa + ssbc;
        String ss1 = a() + bc();
        String ss2 = "ab" + "c";
        System.out.println(ss == ss1);
        System.out.println(ss == ss2);

//        Integer val = 6;
//        Integer val1 = 2 + 4;
//        Integer val2 = 3 + 3;
//        System.out.println(val == val1);
//        System.out.println(val == val2);

    }


//    String ss1 = a() + bc();
    private final static String a() {
        return "a";
    }

    private final static String bc() {
        return "bc";
    }
}
