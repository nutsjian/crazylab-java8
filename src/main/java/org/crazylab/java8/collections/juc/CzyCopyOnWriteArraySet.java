package org.crazylab.java8.collections.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CzyCopyOnWriteArraySet<E> extends AbstractSet<E>
        implements java.io.Serializable {
    private static final long serialVersionUID = 5457747651344034263L;

    // 底层通过一个 CopyOnWriteArrayList 来维护数据
    private final CzyCopyOnWriteArrayList<E> al;

    public CzyCopyOnWriteArraySet() {
        al = new CzyCopyOnWriteArrayList<E>();
    }

    public CzyCopyOnWriteArraySet(Collection<? extends E> c) {
        if (c.getClass() == CopyOnWriteArraySet.class) {
            @SuppressWarnings("unchecked") CzyCopyOnWriteArraySet<E> cc =
                    (CzyCopyOnWriteArraySet<E>)c;
            al = new CzyCopyOnWriteArrayList<E>(cc.al);
        }
        else {
            al = new CzyCopyOnWriteArrayList<E>();
            al.addAllAbsent(c);
        }
    }

    public int size() {
        return al.size();
    }

    public boolean isEmpty() {
        return al.isEmpty();
    }

    public boolean contains(Object o) {
        return al.contains(o);
    }

    public Object[] toArray() {
        return al.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return al.toArray(a);
    }

    public void clear() {
        al.clear();
    }

    public boolean remove(Object o) {
        return al.remove(o);
    }

    /**
     * 添加操作，通过 CopyOnWriteArrayList.addIfAbset()
     * 循环遍历旧数组，若有与 e 相同的值，return false，否则，插入值并返回 true
     *
     * 性能：由于 Set 需要做到去重的功能，所以这里需要遍历旧数组，性能会有损耗。
     * 但是 CopyOnWriteArrayList 的添加就不需要遍历
     */
    public boolean add(E e) {
        return al.addIfAbsent(e);
    }

    public boolean containsAll(Collection<?> c) {
        return al.containsAll(c);
    }

    /**
     * 批量添加，如果要添加的集合中，在旧数组中有全部存在，则返回 false。
     * 但，主要添加的集合中，有一个在旧数组中不存在，就返回 true
     */
    public boolean addAll(Collection<? extends E> c) {
        return al.addAllAbsent(c) > 0;
    }

    public boolean removeAll(Collection<?> c) {
        return al.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return al.retainAll(c);
    }

    public Iterator<E> iterator() {
        return al.iterator();
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Set))
            return false;
        Set<?> set = (Set<?>)(o);
        Iterator<?> it = set.iterator();

        // Uses O(n^2) algorithm that is only appropriate
        // for small sets, which CopyOnWriteArraySets should be.

        //  Use a single snapshot of underlying array
        Object[] elements = al.getArray();
        int len = elements.length;
        // Mark matched elements to avoid re-checking
        boolean[] matched = new boolean[len];
        int k = 0;
        outer: while (it.hasNext()) {
            if (++k > len)
                return false;
            Object x = it.next();
            for (int i = 0; i < len; ++i) {
                if (!matched[i] && eq(x, elements[i])) {
                    matched[i] = true;
                    continue outer;
                }
            }
            return false;
        }
        return k == len;
    }

    public boolean removeIf(Predicate<? super E> filter) {
        return al.removeIf(filter);
    }

    public void forEach(Consumer<? super E> action) {
        al.forEach(action);
    }

    public Spliterator<E> spliterator() {
        return Spliterators.spliterator
                (al.getArray(), Spliterator.IMMUTABLE | Spliterator.DISTINCT);
    }

    private static boolean eq(Object o1, Object o2) {
        return (o1 == null) ? o2 == null : o1.equals(o2);
    }
}
