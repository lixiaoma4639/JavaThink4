package java核心编程.第30章设计模式.单例模式;

/**
 * 同步方法版（线程安全但效率低）
 * 每次获取实例都要同步，性能差
 */
public class SynchronizedSingleton {
    private static SynchronizedSingleton instance;

    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
