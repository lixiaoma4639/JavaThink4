package java核心编程.第21章并发.共享受限资源;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日期 : 2020/12/21.
 * 创建 : xin.li
 * 描述 :
 */
class AtomicityTest implements Runnable{
    private int value;

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        AtomicityTest atomicityTest = new AtomicityTest();
        es.execute(atomicityTest);
        while (true){
            int value = atomicityTest.getValue();
            if (value % 2 != 0){
                System.out.println(value);
                System.exit(0);
            }
        }
    }

    public synchronized void evenIncrement(){
        value++;
        value++;
    }

    @Override
    public void run() {
        while (true) evenIncrement();
    }
}
