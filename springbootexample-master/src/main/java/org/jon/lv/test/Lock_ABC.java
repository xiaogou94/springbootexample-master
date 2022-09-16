package org.jon.lv.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Lock_ABC {
    private int num; // 当前状态值：保证三个线程之间交替打印
    private Lock lock = new ReentrantLock();

    private void printABC(String name, int targetNum) {
        for (int i = 0; i < 10; ) {
            lock.lock();
            if (num % 3 == targetNum) {
                num++;
                i++;
                System.out.print(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock_ABC lockABC = new Lock_ABC();
        new Thread(() -> {
            lockABC.printABC("A", 0);
        }, "A").start();
        new Thread(() -> {
            lockABC.printABC("B", 1);
        }, "B").start();
        new Thread(() -> {
            lockABC.printABC("C", 2);
        }, "C").start();
    }
}
