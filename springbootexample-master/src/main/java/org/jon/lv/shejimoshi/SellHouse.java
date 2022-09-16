package org.jon.lv.shejimoshi;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/23 11:31
 * @Description: 目标对象 realSubject
 */
public class SellHouse implements ISellHouse{
    @Override
    public void sell() {
        System.out.println("卖房,自己目标的类");
    }

    @Override
    public void eat() {
        System.out.println("SellHouse 吃饭");
    }
}
