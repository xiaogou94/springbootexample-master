package org.jon.lv.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @Auther: xiaogou
 * @Date: 2022/06/30 21:12
 * @Description: 查看spring生命周期
 */
public class PersonBean implements InitializingBean, BeanFactoryAware, BeanNameAware, DisposableBean {

    private Integer no; // 身份证号

    private String name; // 姓名

    public PersonBean() {
        System.out.println("1.调用构造方法，我出生了");
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2 设置属性：我的名字叫做：" + name);
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4 调用BeanFactoryAware#setFactory方法： 选好学校了");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("3 调用BeanNameAware#setBeanName方法：我要上学了，起了个学名");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("9 DisposableBean#destory: 平淡的一生落幕了");
    }

    public void destoryMethod() {
        System.out.println("10 自定义destory方法： 睡了，别想叫醒我");
    }

    public void work() {
        System.out.println("Bean 使用中，工作，只有对社会没有人的才在放假");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6 InitialzingBean#afterPropertset方法：入学登记");
    }

    public void init() {
        System.out.println("7 自定义方法：努力上学ing");
    }
}
