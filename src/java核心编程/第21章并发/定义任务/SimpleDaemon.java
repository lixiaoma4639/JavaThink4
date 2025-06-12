package java核心编程.第21章并发.定义任务;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/18.
 * 创建 : xin.li
 * 描述 :
 */
class SimpleDaemon implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new SimpleDaemon() );
//            thread.setDaemon(true);
//            thread.start();
//        }
        //或者使用
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new SimpleDaemon());
        }
        System.out.println("所有后台线程开始执行...");
        TimeUnit.SECONDS.sleep(3);
    }
}
