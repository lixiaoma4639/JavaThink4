package java核心编程.第21章并发.性能调优;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日期 : 2021/1/19.
 * 创建 : xin.li
 * 描述 :
 */
abstract class Accumulator {
    public static long cycles = 50000L;
    private static final int N = 4;
    public static ExecutorService exec = Executors.newFixedThreadPool(N * 2);
    private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);
    protected volatile int index = 0;
    protected volatile long value = 0;
    protected static final int SIZE = 100000;
    protected String id = "error";
    protected long duration = 0;
    protected static int[] preLoaded = new int[SIZE];
    static {
        Random random = new Random(47);
        for (int i = 0; i < SIZE; i++) {
            preLoaded[i] = random.nextInt();
        }
    }

    protected abstract void accumulator();
    protected abstract long read();

    private class Modifier implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < cycles; i++) {
                accumulator();
            }
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class Reader implements Runnable {
        private volatile long value;

        @Override
        public void run() {
            for (int i = 0; i < cycles; i++) {
                value = read();
            }
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void timedTest(){
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            exec.execute(new Modifier());
            exec.execute(new Reader());
        }
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        duration = System.nanoTime() - start;
        System.out.println(String.format("%-13s : %13d" , id , duration));
    }

    public static void report(Accumulator acc1 , Accumulator acc2){
        System.out.println(String.format("%-13s : %13d"  ,  acc1.id + "/" + acc2.id , acc1.duration / acc2.duration));
    }
}
