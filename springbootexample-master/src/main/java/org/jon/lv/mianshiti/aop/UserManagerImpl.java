package org.jon.lv.mianshiti.aop;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/19 14:28
 * @Description:
 */
public class UserManagerImpl implements UserManager{
    @Override
    public void addUser(String userName, String password) {
        System.out.println("调用了新增的方法");
        System.out.println("传入了参数为 userName:" + userName + "-----" +"password: " + password);
    }

    @Override
    public void delUser(String userName) {
        System.out.println("调用了删除的方法");
        System.out.println("传入参数为userName:" + userName);
    }
}
