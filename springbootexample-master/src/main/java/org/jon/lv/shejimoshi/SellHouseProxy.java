package org.jon.lv.shejimoshi;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/23 11:35
 * @Description: 再写代理类（Proxy） 中介 静态代理
 */
public class SellHouseProxy implements ISellHouse{

    private ISellHouse target;

    public SellHouseProxy(ISellHouse target) {
        this.target = target;
    }


    @Override
    public void sell() { // 增强目标对象 这段代码中的代理类扩展了目标对象的扩展（记录了开始和结束）
        System.out.println("静态代理开始");
        target.sell();
        System.out.println("静态代理结束");
    }

    @Override
    public void eat() {

    }
}
