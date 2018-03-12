package org.crazylab.java8.collections.common.set;

import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class HashSetTest {

    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>();
        TreeSet<String> set2 = new TreeSet<>();
        set1.add("abc");
        set1.contains("ab");        // map.containsKey
        set1.clear();               // map.clear
        set1.isEmpty();             // map.isEmpty
        set1.remove("ccc");      // map.remove("ccc") == PRESENT
        set1.size();                // map.size()
    }

}
