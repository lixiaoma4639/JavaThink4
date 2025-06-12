package java核心编程.第21章并发.构件.delay;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日期 : 2021/1/15.
 * 创建 : xin.li
 * 描述 :
 */
class DelayedTaskConsume implements Runnable {
    DelayQueue<DelayedTask> delayQueue;

    public DelayedTaskConsume(DelayQueue<DelayedTask> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                DelayedTask take = delayQueue.take();
                take.run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish DelayedTaskConsume...");
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService executorService = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.put(new DelayedTask(random.nextInt(5000)));
        }
        queue.add(new DelayedTask.EndSentinel(5000 , executorService));
        executorService.execute(new DelayedTaskConsume(queue));
    }
}
