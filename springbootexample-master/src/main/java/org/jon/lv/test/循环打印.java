package org.jon.lv.test;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/11 21:55
 * @Description: 循环打印线程
 */
public class 循环打印 {
    public static void main(String[] args) {

    }

    public static class ThreadPrinter implements Runnable {

        private String name;
        private Object prev;
        private Object self;

        public ThreadPrinter(String name, Object prev, Object self) {
            this.name = name;
            this.prev = prev;
            this.self = self;
        }



        @Override
        public void run() {

        }
    }
}
