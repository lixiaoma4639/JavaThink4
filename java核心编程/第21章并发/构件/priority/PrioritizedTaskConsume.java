package java核心编程.第21章并发.构件.priority;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;


/**
 * 日期 : 2021/1/15.
 * 创建 : xin.li
 * 描述 :
 */
class PrioritizedTaskConsume implements Runnable {
    PriorityBlockingQueue<Runnable> queue;

    public PrioritizedTaskConsume(PriorityBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Runnable take = queue.take();
                take.run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish PrioritizedTaskConsume...");
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService executorService = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        executorService.execute(new PrioritizedTaskProducer(queue , executorService));
        executorService.execute(new PrioritizedTaskConsume(queue));
    }

}
