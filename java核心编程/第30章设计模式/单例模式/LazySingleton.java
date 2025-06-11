package java核心编程.第30章设计模式.单例模式;

/**
 * 懒汉式（Lazy Initialization）
 * 多线程环境下可能创建多个实例
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
