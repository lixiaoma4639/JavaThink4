package java核心编程.第30章设计模式.观察者模式.rxjava案例;

/**
 * 发射器
 */
public interface Emitter<T> {
    void onNext(T s) ;
    void onError(Throwable e);
    void onComplete();
}
