package org.jon.lv.shejimoshi;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/23 13:18
 * @Description: CGLib动态代理
 */
public class Client2 {
    public static void main(String[] args) {
        // 创建目标对象
        SellHouse target = new SellHouse();
        // 获取到代理对象，并且将目标对象传递给代理对象
        SellHouse proxyInstance = (SellHouse) new CgLibProxyFactory(target).getProxyInstance();
        // 执行代理对象的方法，触发intercept方法，从而实现对目标对象的调用
        proxyInstance.sell();
    }
}
