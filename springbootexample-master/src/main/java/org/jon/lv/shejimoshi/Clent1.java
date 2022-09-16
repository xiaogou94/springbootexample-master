package org.jon.lv.shejimoshi;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/23 12:01
 * @Description: 客户端测试动态
 */
public class Clent1 {
    public static void main(String[] args) {
        // 创建目标对象
        ISellHouse target = new SellHouse();

        // 创建代理目标
        ISellHouse proxyInstance = (ISellHouse) new ProxyFactory(target).getProxyInstance();

        // 通过代理对象，调用目标对象的方法
        proxyInstance.sell();
        proxyInstance.eat();
    }
}
