package java核心编程.第21章并发.构件.CountDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2021/1/13.
 * 创建 : xin.li
 * 描述 :
 */
class TaskPortion implements Runnable{
    private static int counter = 0;
    private static final int id = counter++;
    private static Random random = new Random(47);
    private final CountDownLatch countDownLatch ;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        int size = 100;
        CountDownLatch latch = new CountDownLatch(size);
        for (int i = 0; i < 10; i++) {
            exec.execute(new WaitingTask(latch));
        }

        for (int i = 0; i < size; i++) {
            exec.execute(new TaskPortion(latch));
        }

        System.out.println("运行所有任务....");
        exec.shutdown();
    }

    public TaskPortion(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            downWork();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void downWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println(this + "完成了...");
    }

    @Override
    public String toString() {
        return String.format("TaskPortion %1$-3d" , id);
    }
}
