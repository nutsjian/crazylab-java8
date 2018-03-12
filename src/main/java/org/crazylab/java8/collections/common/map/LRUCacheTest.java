package org.crazylab.java8.collections.common.map;

public class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache<String, Object> cache = new LRUCache<>(3);
        cache.put("a", "abstract");
        cache.put("b", "basic");
        cache.put("c", "c++ awesome");
//        Object o = cache.get("a");
//        System.out.println(o);
        cache.put("d", "dell computer");
        System.out.println(cache);
    }

}
