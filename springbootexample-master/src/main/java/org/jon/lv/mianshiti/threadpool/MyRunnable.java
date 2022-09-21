package org.jon.lv.mianshiti.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/21 14:30
 * @Description:
 */
public class MyRunnable implements Runnable{

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start time= " + simpleDateFormat.format(new Date()));
        processCommand();
        System.out.println(Thread.currentThread().getName() + "end time= " + simpleDateFormat.format(new Date()));
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "command='" + command + '\'' +
                '}';
    }
}
