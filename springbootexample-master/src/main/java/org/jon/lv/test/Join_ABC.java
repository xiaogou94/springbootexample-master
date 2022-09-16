package org.jon.lv.test;

/**
 * @Auther: xiaogou
 * @Date: 2022/08/20 10:44
 * @Description: Join_ABC
 */
public class Join_ABC {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(new printABC(null),"A");
            Thread t2 = new Thread(new printABC(t1),"B");
            Thread t3 = new Thread(new printABC(t2),"C");

            t1.start();
            t2.start();
            t3.start();

            Thread.sleep(10); //这里保证只有t1 t2 t3为一组，进行执行才能保证t1->t2->t3的执行
        }
    }

    static class printABC implements Runnable {

        private Thread beforeThread;

        public printABC(Thread beforeThread) {
            this.beforeThread = beforeThread;
        }
        @Override
        public void run() {
           if (beforeThread != null) {
               try {
                   beforeThread.join();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
