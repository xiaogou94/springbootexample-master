package org.jon.lv.test;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/13 10:44
 * @Description:
 */
public class Future批量接受结果 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        ArrayList<Future> arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Future<Integer> future = executorService.submit(new CallableTask());
            arrayList.add(future);
        }
        Thread.sleep(5000);
        for (int i = 0; i < 20; i++) {
            Future future = arrayList.get(i);
            Object o = future.get();
            System.out.println(o);
        }
    }

    static class CallableTask implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(3000);
            return new Random().nextInt(20);
        }
    }
}
