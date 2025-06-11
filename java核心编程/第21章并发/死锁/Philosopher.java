package java核心编程.第21章并发.死锁;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/29.
 * 创建 : xin.li
 * 描述 :
 */
class Philosopher implements Runnable {
    private Chopsticks left;
    private Chopsticks right;
    private final int id;
    private final int ponderFactory;
    private Random random = new Random(47);

    public static void main1(String[] args) throws IOException {
        int ponder = 0;
        int size = 5;
        ExecutorService executorService = Executors.newCachedThreadPool();
        Chopsticks[] chopsticks = new Chopsticks[size];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopsticks();
        }
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Philosopher(chopsticks[i] , chopsticks[(i+1) % size] , i , ponder));
        }

        System.out.println("退出...");
//        System.in.read();
//        executorService.shutdownNow();
    }

    public static void main(String[] args) throws IOException {
        int ponder = 0;
        int size = 5;
        ExecutorService executorService = Executors.newCachedThreadPool();
        Chopsticks[] chopsticks = new Chopsticks[size];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopsticks();
        }
        for (int i = 0; i < 5; i++) {
            if (i < size - 1){
                executorService.execute(new Philosopher(chopsticks[i] , chopsticks[(i+1)] , i , ponder));
            } else {
                executorService.execute(new Philosopher(chopsticks[0] , chopsticks[i] , i , ponder));
            }
        }

        System.out.println("退出...");
//        System.in.read();
//        executorService.shutdownNow();
    }


    public Philosopher(Chopsticks left, Chopsticks right, int id, int ponderFactory) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactory = ponderFactory;
    }

    public void pause() throws InterruptedException {
        if (ponderFactory == 0 ) return;
        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactory * 250));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("thinking...");
                pause();
                System.out.println("拿起右边的筷子..." + this);
                right.take();
                System.out.println("拿起左边的筷子..." + this);
                left.take();
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}
