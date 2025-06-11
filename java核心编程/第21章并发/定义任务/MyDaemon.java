package java核心编程.第21章并发.定义任务;

import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/18.
 * 创建 : xin.li
 * 描述 :
 */
class MyDaemon implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("开始后台线程任务...");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("任务完成...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyDaemon());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(2);
    }


    static class DaemonSpan implements Runnable{

        @Override
        public void run() {
            while (true)
                Thread.yield();
        }
    }
}
