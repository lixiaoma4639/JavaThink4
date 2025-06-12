package java核心编程.第31章之前未理解;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorSimple {

    public static void main(String[] args) {
        // 创建任务队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);

        // 创建一个线程池执行器
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,  // 核心线程数
                4,  // 最大线程数
                60, // 超时时间
                TimeUnit.SECONDS, // 超时时间单位
                workQueue // 工作队列
        );

        // 提交任务
        for (int i = 0; i < 10; i++) {
            executor.execute(new RunnableTask("Task" + i));
        }

        // 优雅关闭线程池
        executor.shutdown();
        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }


    static class RunnableTask implements Runnable {
        private final String name;

        public RunnableTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is executing task: " + name);
            try {
                // 模拟任务执行时间
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished task: " + name);
        }
    }
}
