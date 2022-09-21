package org.jon.lv.mianshiti.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/19 14:35
 * @Description: JDK动态代理实现InvocationHandler
 */
public class JdkProxy implements InvocationHandler {

    private Object target;// 需要代理的对象

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理开始-------");
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理结束-------");
        return result;
    }

    //定义获取代理对象方法
    private Object getJDKProxy(Object target) {
        //为目标target赋值
        this.target = target;
        // jdk动态代理只能针对实现了接口的类进行代理，newProxyInstance函数所需参数就能看出
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        UserManager userManager = (UserManager) jdkProxy.getJDKProxy(new UserManagerImpl());
        userManager.addUser("admin","123123");
    }
}
