package org.jon.lv.shejimoshi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/23 11:47
 * @Description: 动态代理类
  */
public class ProxyFactory {

    // 维护一个目标对象，Object
    private Object target;
    // 构造器，对target进行初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //动态生成一个代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            // 匿名重写Invoke方法
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理开始");
                Object returnVal = method.invoke(target,args);
                System.out.println("动态代理结束");
                return returnVal;
            }
        });
    }

}
