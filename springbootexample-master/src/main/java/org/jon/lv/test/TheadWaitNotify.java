package org.jon.lv.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/07 13:32
 * @Description:
 */
public class TheadWaitNotify {
    public static void main(String[] args) {
        // 定义一个锁对象
        Object lock = new Object();
        List<String> list = new ArrayList<>();
        //线程A
        Thread threadA = new Thread(() -> {
         synchronized (lock) {
             for (int i = 1; i <= 10; i++) {
                 list.add("abc");
                 System.out.println("线程A添加元素，此时list的size为：" + list.size());
                 try {
                     Thread.sleep(500);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 if (list.size() == 5) {
                     lock.notify(); //唤醒B线程
                 }
             }
         }
        });
        // 线程B
        Thread B = new Thread(() -> {
           while (true) {
               synchronized (lock) {
                   if (list.size() != 5) {
                       try {
                           lock.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   System.out.println("线程B收到通知，开始执行自己的业务。。。");
               }
           }
        });

        // 需要启动线程B
        B.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();
    }
}
