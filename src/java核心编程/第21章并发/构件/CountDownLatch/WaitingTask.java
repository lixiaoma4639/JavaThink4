package java核心编程.第21章并发.构件.CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2021/1/13.
 * 创建 : xin.li
 * 描述 :
 */
class WaitingTask implements Runnable{
    private static int counter = 0;
    private static final int id = counter++;
    private static Random random = new Random(47);
    private final CountDownLatch countDownLatch ;

    public WaitingTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println("lath barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted..");
        }
    }


    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d" , id);
    }
}
