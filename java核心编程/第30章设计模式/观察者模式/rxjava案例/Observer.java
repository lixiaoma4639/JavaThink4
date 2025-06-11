package java核心编程.第30章设计模式.观察者模式.rxjava案例;

/**
 * 观察者
 */
public interface Observer<T> {
    void onSubscribe();
    void onNext(T t) ;
    void onError(Throwable e);
    void onComplete();
}
