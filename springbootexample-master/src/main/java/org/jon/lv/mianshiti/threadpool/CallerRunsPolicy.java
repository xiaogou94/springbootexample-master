package org.jon.lv.mianshiti.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/19 11:45
 * @Description: 将任务分给调用线程来执行，运行当前被丢弃的任务，这样做真不会真的丢弃任务，但是提交的线程性能有可能急剧下降
 */
public class CallerRunsPolicy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
          if (!executor.isShutdown()) {
              r.run();
          }
    }
}
