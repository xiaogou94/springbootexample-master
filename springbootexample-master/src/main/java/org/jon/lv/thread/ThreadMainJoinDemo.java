package org.jon.lv.thread;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/09 15:41
 * @Description: 使用join来保证多线程顺序
 */
public class ThreadMainJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(() -> System.out.println("打开冰箱"));

        final Thread thread2 = new Thread(() -> System.out.println("拿出一瓶牛奶"));

        final Thread thread3 = new Thread(() -> System.out.println("关上冰箱"));

        thread1.start();
//        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
    }
}
