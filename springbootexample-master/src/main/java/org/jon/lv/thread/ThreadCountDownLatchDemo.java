package org.jon.lv.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/09 19:15
 * @Description:
 */
public class ThreadCountDownLatchDemo {

    private static CountDownLatch countDownLatch1 = new CountDownLatch(1);

    private static CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public static void main(String[] args) {
        final Thread thread1 = new Thread(() -> {
            System.out.println("打开冰箱");
            countDownLatch1.countDown();
        });

        final Thread thread2 = new Thread(() -> {
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("拿出一瓶牛奶");
            countDownLatch2.countDown();
        });

        final Thread thread3 = new Thread(() -> {
            try {
                countDownLatch2.await();
                System.out.println("关上冰箱！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 下面三行代码顺序可随意调整
        thread3.start();
        thread1.start();
        thread2.start();
    }
}
