package org.jon.lv.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/09 19:39
 * @Description:
 */
public class DownLoadWorker implements Runnable{

    private String url;

    private CountDownLatch countDownLatch;

    public DownLoadWorker(String url, CountDownLatch countDownLatch) {
        this.url = url;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        // 省略无数业务代码
        System.out.println("线程" + Thread.currentThread().getName() + "开始下载完成");
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        //使用stream 生成5个线程
        List<Thread> workers = Stream.generate(() -> new Thread(new DownLoadWorker("https://image.baidu.com/",countDownLatch))).limit(5).collect(Collectors.toList());
        //运行线程
        workers.forEach(Thread::start);
        // 等待线程完成
        countDownLatch.await();
        System.out.println("图片已经下载完");


        // 线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        final CountDownLatch countDownLatch1 = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> countDownLatch1.countDown());
        }
        countDownLatch1.await();
    }
}
