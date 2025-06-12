package java核心编程.第21章并发.构件.Cyclic;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 日期 : 2021/1/14.
 * 创建 : xin.li
 * 描述 :
 */
class Horse implements Runnable {

    public static int counter = 0;
    private final int id = counter++;
    private static Random random = new Random(47);

    private int strides = 0;

    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier cyclicBarrier) {
        this.barrier = cyclicBarrier;
    }

    public synchronized int getStrides(){
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                barrier.await();
                synchronized (this){
                    strides += random.nextInt(3);
                }

//                System.out.println("hi....");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public String tracks(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            sb.append("*");
        }
        sb.append(id);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "horse " + id + " ";
    }
}
