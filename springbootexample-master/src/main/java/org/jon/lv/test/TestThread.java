package org.jon.lv.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/07 12:56
 * @Description:
 */
public class TestThread {
    // 定义共享变量来实现通信，它需要volatile修饰，否则线程不能及时感知
    static volatile boolean notice = false;

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<>();
        Thread A = new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A添加元素，此时List的size:" + list.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5) {
                    notice = true;
                }
            }
        });

        //线程B
        Thread B = new Thread(() -> {
        while (true) {
            if (notice) {
                System.out.println("线程B收到通知，开始执行自己的业务。。");
                break;
            }
        }
        });

        // 需要先启动线程B
        A.start();
        B.start();
        Thread.sleep(1000);
        // 再启动线程A
    }
}
