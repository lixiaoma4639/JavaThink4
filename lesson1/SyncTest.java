package lesson1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 在Java中，synchronized关键字用于实现线程同步，它可以修饰方法或形成同步代码块。不同的使用方式有不同的锁对象和同步范围，下面详细分析各种用法的区别。
 *
 */
class SyncTest {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

//        Thread thread1 = new Thread(myRunnable , "A");
//        Thread thread2 = new Thread(myRunnable , "B");
//        thread1.start();
//        thread2.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(myRunnable);
        }

//        SyncBean syncBean = new SyncBean();
//        syncBean.requestSdkRegisterCode("AA");
//        syncBean.requestSdkRegisterCode("BB");
    }


    static class MyRunnable implements Runnable {

        private volatile boolean isTrue;

        @Override
        public void run() {
            System.out.println("hello...");
            if (!isTrue){
                synchronized(this){
                    if (!isTrue){
                        for (int i = 0; i < 3; i++) {
                            System.out.println(Thread.currentThread().getName() + "我是 " + i);
                        }
                        isTrue = true;
                    }
                }
            }
            System.out.println("world...");
        }
    }




}
