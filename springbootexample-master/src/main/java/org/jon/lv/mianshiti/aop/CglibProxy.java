package org.jon.lv.mianshiti.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/19 14:59
 * @Description: Cglib动态代理实现MethodIntercept
 */
public class CglibProxy implements MethodInterceptor {

    //需要代理的对象
    private Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib动态代理开始，监听开始。。");
        Object invoke = method.invoke(target,objects);
        System.out.println("Cglib动态代理结束，监听结束。。");
        return invoke;
    }

    //定义获取代理对象方法
    public Object getCglibProxy(Object target) {
        //为目标对象target赋值
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 设置父类，因为Cglib是针对指定的类一个子类，所以需要指定父类
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this); //设置回调
        Object result = enhancer.create();//创建并返回对象
        return result;
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();//实例化CglibProxy 对象
        UserManager userManager = (UserManager) cglibProxy.getCglibProxy(new UserManagerImpl());
        userManager.delUser("admin");
    }
}
