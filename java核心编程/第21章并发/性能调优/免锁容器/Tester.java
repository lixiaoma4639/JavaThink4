package java核心编程.第21章并发.性能调优.免锁容器;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Generated;

import java核心编程.第15章泛型.擦除的补偿.泛型数组.GenericArray;

/**
 * 日期 : 2021/1/20.
 * 创建 : xin.li
 * 描述 :
 */
abstract class Tester<C> {
    static int testReps = 0;
    static int testCycles = 1000;
    static int containerSize = 1000;
    C testContainer;
    String testId;
    int nWrites;
    int nReads;
    volatile long readResult = 0;
    volatile long readTime = 0;
    volatile long writeTime = 0;
    CountDownLatch endLatch;
    static ExecutorService exec = Executors.newCachedThreadPool();
    Integer[] writeData;

    public Tester(String testId, int nReads , int nWrites) {
        this.testId = testId + " " + nReads + "-read " + nWrites + "-write ";
        this.nWrites = nWrites;
        this.nReads = nReads;
        writeData = new Integer[]{1 , 2 , 3 , 5 , 6,23, 54, 64,123, 543 , 3424};
        for (int i = 0; i < testReps; i++) {
            runTest();
            readTime = 0;
            writeTime = 0;
        }
    }

    abstract C containerInit();

    abstract void startReadAndWrite();

    protected void runTest(){
        endLatch = new CountDownLatch(nReads + nWrites);
        testContainer = containerInit();
        startReadAndWrite();
        try {
            endLatch.await();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException....");
        }
        System.out.println(testId + " " + readTime + " " + writeTime);
        if (readTime != 0 && writeTime != 0){
            System.out.println("readTime + writeTime = " + (readTime + writeTime));
        }
    }

    abstract class TestTask implements Runnable {

        long duration;
        abstract void test();
        abstract void putResults();

        @Override
        public void run() {
            long start = System.nanoTime();
            test();
            duration = System.nanoTime() - start;
            synchronized (TestTask.this){
                putResults();
            }
            endLatch.countDown();
        }
    }

    public static void initMain(String[] args) {
        if (args.length > 0) {
            testReps = new Integer(args[0]);
        }
        if (args.length > 1) {
            testCycles = new Integer(args[1]);
        }
        if (args.length > 2) {
            containerSize = new Integer(args[2]);
        }
        System.out.println(String.format("%-27s %14s %14s" , " type " , " read time" , " write time "));
    }
}
