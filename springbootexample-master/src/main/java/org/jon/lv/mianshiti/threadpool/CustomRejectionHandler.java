package org.jon.lv.mianshiti.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: xiaogou
 * @Date: 2022/09/19 11:49
 * @Description: 通过实现RejectedExecutionHandler接口，自定义一个拒绝策略类，重写它的rejectedExecution()方法
 */
public class CustomRejectionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + "被拒绝了，，执行入库操作，之后手动补偿");
    }
}
