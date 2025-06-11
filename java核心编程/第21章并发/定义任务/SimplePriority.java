package java核心编程.第21章并发.定义任务;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/18.
 * 创建 : xin.li
 * 描述 :
 */
class SimplePriority implements Runnable{

    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);

        while (true){
            for (int i = 0; i < 10000000; i++) {
                d += (Math.PI + Math.E) / Integer.valueOf(i).doubleValue();
                if (i % 1000 == 0) Thread.yield();
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 5; i++)
        executorService.execute(new SimplePriority(Thread.MIN_PRIORITY));
        executorService.execute(new SimplePriority(Thread.MAX_PRIORITY));
        executorService.shutdown();

        TimeUnit.SECONDS.sleep(5);
    }
}
