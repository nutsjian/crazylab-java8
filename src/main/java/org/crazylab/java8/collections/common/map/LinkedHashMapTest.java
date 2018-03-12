package org.crazylab.java8.collections.common.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        loopLinkedHashMap(map);
        map.get("3");
        loopLinkedHashMap(map);
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("8", "8");
        map.put("9", "9");
        map.put("10", "10");
        map.put("11", "11");
        map.put("12", "12");
        map.put("13", "13");
        map.put("14", "14");
        map.put("15", "15");
        map.put("16", "16");
        map.put("17", "17");
        map.put("18", "18");
        loopLinkedHashMap(map);
    }

    private static void loopLinkedHashMap(LinkedHashMap<String, String> linkedHashMap)
    {
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();

        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
    }

}
