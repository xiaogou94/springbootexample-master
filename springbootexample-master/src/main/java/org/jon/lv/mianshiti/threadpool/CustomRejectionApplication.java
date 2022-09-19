package org.jon.lv.mianshiti.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/19 11:51
 * @Description: 因为核心线程数和最大线程数都是5，而队列容量都是5，所以同一时间最多可接受10个任务，加了睡眠
 * 时间1，然后可以发现20个任务只有10个被执行，剩下的10个都做了自定义拒绝策略。
 */
public class CustomRejectionApplication {
    // 1.AtomicInteger作为多个线程同时使用的原子计数器，2 在比较和交换操作中实现非阻塞算法
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        CustomRejectionHandler customRejectionHandler = new CustomRejectionHandler();
        ExecutorService executorService = new ThreadPoolExecutor(5,5,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(5),customRejectionHandler);
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                System.out.println("第" + atomicInteger.getAndIncrement() + "个任务被执行");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
