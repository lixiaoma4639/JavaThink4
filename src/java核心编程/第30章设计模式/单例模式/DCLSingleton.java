package java核心编程.第30章设计模式.单例模式;

/**
 * 双重检查锁定（DCL，推荐）
 */
public class DCLSingleton {

    // volatile保证可见性和禁止指令重排序
    private volatile static DCLSingleton instance;

    private DCLSingleton() {}

    public static DCLSingleton getInstance() {
        if (instance == null) {  // 第一次检查
            synchronized (DCLSingleton.class) {
                if (instance == null) {  // 第二次检查
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
