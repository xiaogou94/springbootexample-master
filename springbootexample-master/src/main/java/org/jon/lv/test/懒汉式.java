package org.jon.lv.test;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/23 11:04
 * @Description:
 */
public class 懒汉式 {

    private static 懒汉式 singleton; // 和饿汉式不同的是，这里没有进行实例化

    private 懒汉式() {};

    public static 懒汉式 getInstance() {
        if (singleton == null) {
            singleton = new 懒汉式();
        }
        return singleton;
    }
}
