package java核心编程.第21章并发.共享受限资源;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2021/1/22.
 * 创建 : xin.li
 * 描述 :
 */
class Accessor implements Runnable{
    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalHandler.increment();
            System.out.println(this);
            System.out.println(ThreadLocalHandler.value);
            Thread.yield();
            return;
        }
    }

    @Override
    public String toString() {
        return "# " + id + ": " + ThreadLocalHandler.get().getNumber();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }
        System.out.println(ThreadLocalHandler.value);
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }


    static class ThreadLocalHandler{
        private static ThreadLocal<AccessorBean> value = new ThreadLocal<AccessorBean>(){
            private Random random = new Random(47);

            @Override
            protected AccessorBean initialValue() {
                return new AccessorBean(random.nextInt(10000));
            }
        };

        public static void increment(){
            value.set(new AccessorBean(value.get().getNumber() + 1));
        }
        public static AccessorBean get(){
            System.out.println(value.get());
            return value.get();
        }

        public static ThreadLocal<AccessorBean> getValue() {
            return value;
        }
    }


}
