package java核心编程.第21章并发.性能调优.读写锁;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2021/1/21.
 * 创建 : xin.li
 * 描述 :
 */
class ReaderWriterLockTest {
    ExecutorService exec = Executors.newCachedThreadPool();
    private static final int SIZE = 20;
    private static Random random = new Random(47);
    private ReaderWriterLock<Integer> list = new ReaderWriterLock<>(SIZE , 0);

    public static void main(String[] args) {
        new ReaderWriterLockTest(30 , 1);
    }

    public ReaderWriterLockTest(int reads , int writes) {
        for (int i = 0; i < reads; i++) {
            exec.execute(new Reader());
        }
        for (int i = 0; i < writes; i++) {
            exec.execute(new Writer());
        }
    }

    private class Writer implements Runnable{

        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    list.set(i , random.nextInt());
                    TimeUnit.MILLISECONDS.sleep(1);
                }
            } catch (InterruptedException e) {

            }
            System.out.println("write finish ,  shutdown...");
//            exec.shutdownNow();
        }
    }

    private class Reader implements Runnable{

        @Override
        public void run() {

            try {
                while (!Thread.interrupted()){
                    for (int i = 0; i < SIZE; i++) {
                        list.get(i);
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException e) {

            }
        }
    }


}
