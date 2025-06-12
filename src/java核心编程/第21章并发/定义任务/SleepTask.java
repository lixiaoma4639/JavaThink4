package java核心编程.第21章并发.定义任务;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/17.
 * 创建 : xin.li
 * 描述 :
 */
class SleepTask extends LiftOff {

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print("# " + Id + "(" + countDown + ") , ");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SleepTask());
        }
        executorService.shutdown();
    }
}
