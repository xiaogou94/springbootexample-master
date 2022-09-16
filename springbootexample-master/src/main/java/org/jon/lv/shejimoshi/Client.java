package org.jon.lv.shejimoshi;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/23 11:41
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        //创建目标对象
        SellHouse sellHouse = new SellHouse();

        // 创建代理对象，将目标对象传递给代理对象
        SellHouseProxy sellHouseProxy = new SellHouseProxy(sellHouse);

        //通过代理对象，调用目标对象的方法
        sellHouseProxy.sell();
    }
}
