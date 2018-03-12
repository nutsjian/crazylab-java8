//package org.crazylab.java8.collections.common;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Spliterator;
//
//public class ArrayListAndLinkedListForEachCompareExample {
//
//
//    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i=0; i<100000; i++) {
//            arrayList.add(i);
//            linkedList.add(i);
//        }
//
//        long start = System.currentTimeMillis();
//        for (int j=0; j<arrayList.size(); j++) {
//            arrayList.get(j);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("loop array list cost " + (end - start) + "ms");
//
////        long start2 = System.currentTimeMillis();
////        for (int k=0; k<linkedList.size(); k++) {
////            linkedList.get(k);
////        }
////        long end2 = System.currentTimeMillis();
////        System.out.println("loop linked list cost " + (end2 - start2) + "ms");
//
//
//        long start3 = System.currentTimeMillis();
//        int sum3 = 0;
//        Iterator<Integer> it = linkedList.iterator();
//        while (it.hasNext()) {
//            sum3+=it.next();
//        }
//        long end3 = System.currentTimeMillis();
//        System.out.println("loop linked list cost " + (end3 - start3) + "ms");
//
//        long start4 = System.currentTimeMillis();
////        linkedList.forEach((m) -> {});
//        final int sum4 = 0;
//        linkedList.forEach(m -> sum4+=m.intValue());
//        long end4 = System.currentTimeMillis();
//        System.out.println("loop linked list cost " + (end4 - start4) + "ms");
//
//        long start5 = System.currentTimeMillis();
//        for (Integer str: linkedList) {
//        }
//        long end5 = System.currentTimeMillis();
//        System.out.println("loop linked list cost " + (end5 - start5) + "ms");
//
//
////        Spliterator<Integer> spitr = arrayList.spliterator();
////        while (spitr.)
//
//    }
//
//}
