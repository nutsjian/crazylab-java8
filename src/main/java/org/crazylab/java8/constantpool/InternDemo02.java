package org.crazylab.java8.constantpool;

public class InternDemo02 {

    /**
     * 注释（1）返回 false
     * 注释（2）返回 true
     *
     * TODO 了解下 intern() 方法的作用  http://blog.csdn.net/baidu_31657889/article/details/52315902
     */
    public static void main(String[] args) {
//        String s = new String("AB" + "OP");     // (1) 在常量区没有生成 "OP"，所以 s1.intern() 会把自己的引用传进常量区，然后 s1.intern() == s1 就是 true
        String s = new String("OP");    // (2) 首先会在常量区中生成 "OP" 对象的引用，所以 s1.intern() 会直接使用常量区中的引用，而本来的 s1 是另外一个对象的引用。所以 s1.intern() == s1 就是 false
        String s1 = new StringBuilder().append("O").append("P").toString();
        System.out.println(s1.intern() == s1);
    }

}
