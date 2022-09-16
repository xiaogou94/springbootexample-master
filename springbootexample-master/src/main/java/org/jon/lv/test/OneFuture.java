package org.jon.lv.test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/13 10:39
 * @Description:
 */
public class OneFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(new CallableTask());

        System.out.println(future.get());

    }

    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt(10);
        }
    }
}
