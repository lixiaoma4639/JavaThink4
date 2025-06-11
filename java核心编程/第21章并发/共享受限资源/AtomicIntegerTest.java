package java核心编程.第21章并发.共享受限资源;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 日期 : 2020/12/22.
 * 创建 : xin.li
 * 描述 :
 */
class AtomicIntegerTest implements Runnable{
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int getValue(){
        return atomicInteger.get();
    }
    public  void evenIncrement(){
        atomicInteger.addAndGet(2);
        System.out.println(atomicInteger.get());
    }

    @Override
    public void run() {
        while (true) evenIncrement();
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("中断...");
                System.exit(0);
            }
        } , 5000);

        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        executorService.execute(atomicIntegerTest);
        while (true){
            int value = atomicIntegerTest.getValue();
            if (value % 2 != 0) {
                System.out.println("中断2...");
                System.exit(0);
            }
        }
    }
}
