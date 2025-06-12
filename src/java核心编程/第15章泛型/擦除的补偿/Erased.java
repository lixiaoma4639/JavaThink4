package java核心编程.第15章泛型.擦除的补偿;

/**
 * 日期 : 2020/12/5.
 * 创建 : xin.li
 * 描述 :
 */
class Erased<T> {

    private static final int size = 100;

    public static void f(Object args) {
//        args instanceof T;
//        T[] var = new T[size];
//        T[] ts = (T) new Object[size];
    }
}
