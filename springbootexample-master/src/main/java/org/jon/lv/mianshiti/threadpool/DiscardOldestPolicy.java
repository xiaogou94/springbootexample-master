package org.jon.lv.mianshiti.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/19 11:42
 * @Description: 丢弃队列中最老的任务，尝试再次提交当前任务
 */
public class DiscardOldestPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (!executor.isShutdown()) {
            executor.getQueue().poll();
            executor.execute(r);
        }
    }
}
