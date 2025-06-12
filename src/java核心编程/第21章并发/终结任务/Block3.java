package java核心编程.第21章并发.终结任务;

import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/26.
 * 创建 : xin.li
 * 描述 :
 */
class Block3 {
    public static void main(String[] args) {
        boolean interrupted = Thread.interrupted();
        Thread thread = new Thread();
        thread.interrupt();
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
