package java核心编程.第21章并发.线程协作.notif和notifyAll;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/27.
 * 创建 : xin.li
 * 描述 :
 */
class Blocker {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task1());
        }
        executorService.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;

            @Override
            public void run() {
                if (prod){
                    System.out.println("notify()...");
                    Task1.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("notifyAll()...");
                    Task1.blocker.prodAll();
                    prod = true;
                }
            }
        } , 400 , 400);

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("timer canceled ... ");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task2.blocker.prodAll() ... ");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("shutdown() ... ");
        executorService.shutdownNow();
    }

    public synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()){
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void prod() {
        notify();
    }

    public synchronized void prodAll() {
        notifyAll();
    }
}
