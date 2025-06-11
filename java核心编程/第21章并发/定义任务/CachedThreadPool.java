package java核心编程.第21章并发.定义任务;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日期 : 2020/12/17.
 * 创建 : xin.li
 * 描述 :
 */
class CachedThreadPool {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
        for (int i = 0; i < 2; i++) {
            executorService.execute(new LiftOff());
        }
        System.out.println("等待...");
    }


}
