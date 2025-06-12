package java核心编程.第31章之前未理解;

public class ThreadLocalBasicExample {
    // 创建ThreadLocal变量
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);


    public static void main(String[] args) {
        // 在主线程设置值
        threadLocalValue.set(100);
        System.out.println(Thread.currentThread().getName() + ": " + threadLocalValue.get());

        // 创建新线程
        Thread thread = new Thread(() -> {
            // 在新线程中设置不同的值
            threadLocalValue.set(200);
            System.out.println(Thread.currentThread().getName() + ": " + threadLocalValue.get());
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 主线程的值不受新线程影响
        System.out.println(Thread.currentThread().getName() + ": " + threadLocalValue.get());
    }
}
