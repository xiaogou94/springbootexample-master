package org.jon.lv.test;

import java.util.concurrent.*;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/13 11:04
 * @Description:
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task task = new Task();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(task);
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(integerFutureTask);

        System.out.println("task运行结果：" + integerFutureTask.get());
    }

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程正在计算");
            Thread.sleep(3000);
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
