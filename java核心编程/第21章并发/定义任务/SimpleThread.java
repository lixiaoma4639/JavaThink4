package java核心编程.第21章并发.定义任务;

import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/20.
 * 创建 : xin.li
 * 描述 :
 */
class SimpleThread implements Runnable {

    private Thread thread = new Thread(this);

    public SimpleThread() {
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SimpleThread();
    }

    @Override
    public void run() {

        try {
            System.out.println("start...");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("over...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
