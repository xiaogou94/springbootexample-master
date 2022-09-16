package org.jon.lv.test;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/27 10:26
 * @Description:
 */
public class DeadLockDemo {

    private static Object resource1 = new Object(); // 资源1
    private static Object resource2 = new Object(); // 资源2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "wait get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        },"线程 1").start();

        new Thread(() -> {
        synchronized (resource2) {
            System.out.println(Thread.currentThread() + "get resource2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "waiting get resource1");
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
            }
        }
        },"线程 2").start();
    }
}
