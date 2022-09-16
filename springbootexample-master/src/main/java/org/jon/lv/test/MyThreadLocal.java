package org.jon.lv.test;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/07 16:56
 * @Description:
 */
public class MyThreadLocal {
    //ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
    private static final ThreadLocal<Object> threadLocal = ThreadLocal.withInitial(() -> {
        System.out.println("调用get()时，当前线程共享变量没有设置，调initialValue获取默认值");
        return null;
    });

    public static void main(String[] args) {
//        new Thread(new MyIntegerTask("IntegerTask1")).start();
//        new Thread(new MyStringTask("StringTask1")).start();
//        new Thread(new MyIntegerTask("IntegerTask2")).start();
//        new Thread(new MyStringTask("StringTask2")).start();
    }

    public static class MyIntegerTask implements Runnable {

        private String name;

        public MyIntegerTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                if (null == MyThreadLocal.threadLocal.get()) {
                    MyThreadLocal.threadLocal.set(0);
                    System.out.println("线程:" + name + ":0");
                }else {
                    int num = (int) MyThreadLocal.threadLocal.get();
                    MyThreadLocal.threadLocal.set(num + 1);
                    System.out.println("线程：" + name + ":" + MyThreadLocal.threadLocal.get());
                }
            }
        }
    }
}
