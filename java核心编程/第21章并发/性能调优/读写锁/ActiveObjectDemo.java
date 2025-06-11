package java核心编程.第21章并发.性能调优.读写锁;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2021/1/21.
 * 创建 : xin.li
 * 描述 :
 */
class ActiveObjectDemo {
    private static Random random = new Random(47);
    static ExecutorService exec = Executors.newSingleThreadExecutor();

    private void pause(int factor) {
        try {
            TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(factor));
        } catch (InterruptedException e) {
            System.out.println("sleep 中断...");
        }
    }

    public Future<Integer> calculateInt(int x, int y) {

        return exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("开始 x = " + x + " y = " + y);
                pause(500);
                return x + y;
            }
        });
    }

    public Future<Float> calculateFloat(float x, float y) {

        return exec.submit(new Callable<Float>() {
            @Override
            public Float call() throws Exception {
                System.out.println("开始 x = " + x + " y = " + y);
                pause(2000);
                return x + y;
            }
        });
    }

    public void shutdown() {
        exec.shutdownNow();
    }

    public static void main(String[] args) {
        ActiveObjectDemo activeObjectDemo1 = new ActiveObjectDemo();
        CopyOnWriteArrayList<Future<?>> results = new CopyOnWriteArrayList<>();
        for (float i = 0.0f; i < 1.0; i += 0.2f) {
            results.add(activeObjectDemo1.calculateFloat(i, i));
        }
        System.out.println("==============");
        for (int i = 0; i < 5; i++) {
            results.add(activeObjectDemo1.calculateInt(i, i));
        }
        ActiveObjectDemo activeObjectDemo2 = new ActiveObjectDemo();
        for (int i = 10; i < 15; i++) {
            results.add(activeObjectDemo2.calculateInt(i, i));
        }
        System.out.println("all synchronized calls mode");
        while (results.size() > 0) {
            for (Future<?> future : results) {
                if (future.isDone()) {
                    try {
                        System.out.println(future.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    results.remove(future);
                }

            }
        }
        activeObjectDemo1.shutdown();
    }
}
