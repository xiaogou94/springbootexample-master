package org.jon.lv.test;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/20 10:55
 * @Description:
 */
public class Wait_Notify_Odd_Even {

    private Object monitor = new Object();
    private volatile int count;

    public Wait_Notify_Odd_Even(int count) {
        this.count = count;
    }

    private void printOddEven() {
        synchronized (monitor) {
            while (count < 10) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
