package org.jon.lv.mianshiti.threadLocal;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/21 12:08
 * @Description: threadlocal例子 启动三个线程，每个线程最后打印到“ThreadLoacl num=5 而不是一直累加到15”
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) { //启动三个线程
            Thread t = new Thread(() -> add10ByThreadLocal());
            t.start();
        }
    }

    //线程本地存储变量
    private static final ThreadLocal<Integer> THREAD_LOCAL_NUM = ThreadLocal.withInitial(() -> 0);

    // 线程本地存储变量加5
    private static void add10ByThreadLocal(){
        for (int i = 0; i < 5; i++) {
            Integer n = THREAD_LOCAL_NUM.get();
            n += 1;
            THREAD_LOCAL_NUM.set(n);
            System.out.println(Thread.currentThread().getName() + ": ThreadLocal num=" + n);
        }
    }
}
