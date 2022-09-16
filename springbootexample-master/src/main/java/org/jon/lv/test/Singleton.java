package org.jon.lv.test;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/23 11:02
 * @Description: 饿汉式
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    public Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
