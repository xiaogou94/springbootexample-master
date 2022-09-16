package org.jon.lv.shejimoshi;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/23 12:33
 * @Description:
 */
public class CgLibProxyFactory implements MethodInterceptor {

    //目标对象
    private Object target;

    public CgLibProxyFactory(Object target) {
        this.target = target;
    }

    //返回target对象代理的对象
    public Object getProxyInstance() {
        //创建一个工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类对象，及代理对象
        return enhancer.create();
    }

    // 重写intercept方法，会调用目标对象的方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("动态代理开始");
        Object returnValue = method.invoke(target,objects);
        System.out.println("动态代理结束");
        return returnValue;
    }
}
