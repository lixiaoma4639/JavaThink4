package java核心编程.第21章并发.共享受限资源;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日期 : 2020/12/20.
 * 创建 : xin.li
 * 描述 : 偶数检查
 */
public class EvenChecker implements Runnable {
    private final int Id;
    private IntGenerator intGenerator;

    public EvenChecker(IntGenerator intGenerator, int id) {
        Id = id;
        this.intGenerator = intGenerator;
    }

    public static void test(IntGenerator ig) {
        test(ig , 10);
    }

    public static void test(IntGenerator ig, int count) {
        System.out.println("按压control + c退出...");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(ig, i));
        }
        executorService.shutdown();
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();
            System.out.println(val);
            if (val % 2 != 0) {
                System.out.println(val + " 不是偶数...");
                intGenerator.cancel();
            }
        }
    }


}
