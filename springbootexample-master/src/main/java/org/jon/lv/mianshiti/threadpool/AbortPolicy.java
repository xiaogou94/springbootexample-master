package org.jon.lv.mianshiti.threadpool;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/19 11:44
 * @Description: 直接跑异常，阻止系统正常工作
 */
public class AbortPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        throw new RejectedExecutionException("Task" + r.toString() + "reject from" + executor.toString());
    }
}
