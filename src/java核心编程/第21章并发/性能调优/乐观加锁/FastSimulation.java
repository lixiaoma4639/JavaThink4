package java核心编程.第21章并发.性能调优.乐观加锁;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 日期 : 2021/1/20.
 * 创建 : xin.li
 * 描述 :
 */
class FastSimulation {
    static final int N_ELEMENT = 100000;
    static final int N_GENES = 30;
    static final int N_EVOLVERS = 50;
    static final AtomicInteger[][] GRID = new AtomicInteger[N_ELEMENT][N_GENES];
    static Random random = new Random(47);

    static class Evolver implements Runnable{

        @Override
        public void run() {
            while (!Thread.interrupted()){
                int element = random.nextInt(N_ELEMENT);
                for (int i = 0; i < N_GENES; i++) {
                    int previous = element -1 ;
                    if (previous <0 ) previous = N_ELEMENT - 1;
                    int next = element + 1;
                    if (next > N_GENES) next = 0;
                    int oldValue = GRID[element][i].get();
                    int newValue = oldValue + GRID[element][i].get() + GRID[next][i].get();
                    newValue /= 3;
                    if (!GRID[element][i].compareAndSet(oldValue , newValue)){
                        System.out.println("old value change form " + oldValue);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < N_ELEMENT; i++) {
            for (int j = 0; j < N_GENES; j++) {
                GRID[i][j] = new AtomicInteger(random.nextInt(1000));
            }
        }
        for (int i = 0; i < N_EVOLVERS; i++) {
            exec.execute(new Evolver());
        }
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
