package org.jon.lv.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/09 20:15
 * @Description:
 */
public class CountDownLatchDemo1 {

    private static Object o1;

    public static void main(String[] args) throws InterruptedException {
//        closeDoor();

        Map<String,String> map = new HashMap<>();
        map.put("1","xiaoxiao");
        String val = map.put("1","gou");
        System.out.println(val);
        Object o = new Object();
        o1 = new Object();
        new Object();
    }

    private static void closeDoor() throws InterruptedException {
        // 创建CountDownLatch，初始容量为10，模拟10名员工
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "忙完工作，下班");
                // 计数器减少1
                countDownLatch.countDown();
            }, "员工编号：" + i).start();
        }
        // 当计数器值变为0，因为调用await()方法阻塞的线程会被唤醒
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t值班人员锁门离开公司");
    }
}