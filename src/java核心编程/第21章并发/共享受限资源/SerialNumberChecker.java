package java核心编程.第21章并发.共享受限资源;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日期 : 2020/12/21.
 * 创建 : xin.li
 * 描述 :
 */
class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet circularSet = new CircularSet(10000);
    private static ExecutorService executors = Executors.newCachedThreadPool();


    static class SerialChecker implements Runnable {

        @Override
        public void run() {
            int serial = SerialNumberGenerator.nextSerialNumber();
            if (circularSet.contains(serial)){
                System.out.println("包含 " + serial);
                System.exit(0);
            }
            circularSet.add(serial);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            executors.execute(new SerialChecker());
        }
    }
}
