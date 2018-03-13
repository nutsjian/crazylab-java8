package org.crazylab.java8.lock;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo01 {

    public static void main(String[] args) {
        User user = new User("nutsjian", 0);
        AtomicStampedReference<User> reference = new AtomicStampedReference<>(user, 0);

        User newUser = new User("jange", 100);
        // 修改对象
        boolean flag = reference.compareAndSet(user, newUser, reference.getStamp(), reference.getStamp()+1);
//        boolean flag = reference.compareAndSet(newUser, user, reference.getStamp(), reference.getStamp()+1);
        System.out.println(flag);
        System.out.println(reference.getReference().toString());
    }

    private static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "name = " + this.name + " , age = " + this.age;
        }
    }

}
