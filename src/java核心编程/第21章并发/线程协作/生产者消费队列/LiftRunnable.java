package java核心编程.第21章并发.线程协作.生产者消费队列;

import java.util.concurrent.BlockingQueue;

import java核心编程.第21章并发.定义任务.LiftOff;

/**
 * 日期 : 2020/12/27.
 * 创建 : xin.li
 * 描述 :
 */
class LiftRunnable implements Runnable {
    private BlockingQueue<LiftOff> blockingQueues;

    public LiftRunnable(BlockingQueue<LiftOff> blockingQueues) {
        this.blockingQueues = blockingQueues;
    }

    public void add(LiftOff liftOff){
        try {
            blockingQueues.put(liftOff);
        } catch (InterruptedException e) {
            System.out.println("Interrupted in put()...");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("开始获取...");
                LiftOff take = blockingQueues.take();
                System.out.println("取到了...");
                take.run();
                System.out.println("等待吗...");
            }
        } catch (InterruptedException e) {
            System.out.println("walking from take()...");
        }
        System.out.println("退出了...");
    }
}
