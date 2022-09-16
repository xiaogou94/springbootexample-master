package org.jon.lv.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: xiaogou
 * @Date: 2022/06/30 21:31
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        PersonBean personBean = (PersonBean) context.getBean("personBean");
        personBean.work();
        context.destroy();
    }
}
