package org.crazylab.java8.collections.juc.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class CzyPriorityBlockingQueueTest {

    public static void main(String[] args) {
//        final BlockingQueue<Order> priorityBlockingQueue = new LinkedBlockingQueue<>();
        final PriorityBlockingQueue<Order> priorityBlockingQueue = new PriorityBlockingQueue<>();

        AddOrderThread queueProducer = new AddOrderThread(priorityBlockingQueue);
        new Thread(queueProducer).start();

        ShippingOrderThread queueConsumer = new ShippingOrderThread(priorityBlockingQueue);
        new Thread(queueConsumer).start();
    }

    private enum PRIORITY {
        NORMAL(1), EXPRESS(2), SAME_OF_DELIVERY(3);

        private final Integer value;

        PRIORITY(int v) {
            value = v;
        }

        public Integer value() {
            return value;
        }

        public static PRIORITY fromValue(int v) {
            for (PRIORITY priority : PRIORITY.values()) {
                if (priority.value == v) {
                    return priority;
                }
            }
            throw new IllegalArgumentException(String.valueOf(v));
        }
    }

    private static class Inventory {
        private static final String[] items = {
                "shoes",
                "hanger",
                "blanket",
                "soap",
                "sticky note",
                "sketch pad",
                "television",
                "nail file",
                "clothes"
        };

        public static String getRandomItem() {
            int index = (new Random()).nextInt(items.length);
            if (index == items.length)
                index = (items.length - 1);
            return items[index];
        }
    }

    private static class Order implements Comparable<Order> {
        private Integer orderId;
        private String item;
        private String shippingAddress;
        private PRIORITY priority;

        public Order(Integer orderId, String item, PRIORITY priority) {
            super();
            this.orderId = orderId;
            this.item = item;
            this.priority = priority;
        }

        public String getShippingAddress() {
            return shippingAddress;
        }

        public void setShippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public String getItem() {
            return item;
        }

        public PRIORITY getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Order o) {
            return this.priority.value().compareTo(o.getPriority().value());
        }

        @Override
        public String toString() {
            return "Order [orderId=" + orderId + ", item=" + item + ", shippingAddress=" + shippingAddress + ", priority=" + priority + "]";
        }
    }

    private static class AddOrderThread implements Runnable {
        BlockingQueue<Order> orderQueue;
        public AddOrderThread(BlockingQueue<Order> orderQueue) {
            this.orderQueue = orderQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Order order = getNextPalcedOrder();
                    System.out.println(" ------------------------- New Order ------------------------- ");
                    System.out.println("Adding to Queue: " + order);
                    orderQueue.put(order);
                    System.out.println(" ------------------------------------------------------------- ");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * This is Just a Mock method which is returning a
         * Order with random Data
         */
        private Order getNextPalcedOrder() {
            Integer orderId = getRandomInRange(10000, 1);
            String item = Inventory.getRandomItem();
            Integer priority = getRandomInRange(3, 1);
            priority = priority == 0 ? PRIORITY.NORMAL.value() : priority;
            Order order = new Order(orderId, item, PRIORITY.fromValue(priority));
            order.setShippingAddress("Shipping Address");
            return order;
        }

        private int getRandomInRange(int maximum, int minimum) {
            return (new Random()).nextInt(maximum - minimum + 1) + minimum;
        }
    }


    private static class ShippingOrderThread implements Runnable {
        BlockingQueue<Order> orderQueue;
        public ShippingOrderThread(BlockingQueue<Order> orderQueue) {
            this.orderQueue = orderQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Order order = orderQueue.take();
                    System.out.println(" ------------------------- SHIPPING ------------------------- ");
                    System.out.println(" Order shipped " + order);
                    System.out.println(" ------------------------------------------------------------- ");
                    System.out.println();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
