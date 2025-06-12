package java核心编程.第21章并发.线程协作.生产者消费队列;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import java核心编程.第21章并发.定义任务.LiftOff;

/**
 * 日期 : 2020/12/27.
 * 创建 : xin.li
 * 描述 :
 */
class TestBlockQueue {
    static void getKey(){

    }

    static void test(BlockingQueue<LiftOff> queues) throws InterruptedException {
        LiftRunnable liftRunnable = new LiftRunnable(queues);
        Thread thread = new Thread(liftRunnable);
        thread.start();

        System.out.println("开始测试....");
        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i < 5; i++) {
            queues.add(new LiftOff(5));
            System.out.println("放进去了 " + i);
        }

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println("结束测试....");
    }

    public static void main(String[] args) throws InterruptedException {
//        test(new LinkedBlockingQueue<LiftOff>());
        test(new ArrayBlockingQueue<>(5));
//        test(new SynchronousQueue<>());
    }
}
