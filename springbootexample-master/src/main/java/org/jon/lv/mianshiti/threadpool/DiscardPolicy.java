package org.jon.lv.mianshiti.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/19 11:41
 * @Description: DiscardPolicy是线程池默认的拒绝策略，默默丢弃无法处理的任务，不予任何处理
 */
public class DiscardPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

    }
}
