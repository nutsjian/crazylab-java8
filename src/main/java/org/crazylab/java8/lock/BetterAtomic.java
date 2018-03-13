package org.crazylab.java8.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class BetterAtomic {
    AtomicInteger ai = new AtomicInteger();

    public int incrementAndGet() {
        for(;;) {
            int current = ai.get();
            int next = current + 1;
            if (compareAndSet(current, next))
                return next;
        }
    }

    private boolean compareAndSet(int current, int next) {
        if (ai.compareAndSet(current, next)) {
            return true;
        } else {
            // 暂停 1 纳秒
            LockSupport.parkNanos(1);
            return false;
        }
    }
}
