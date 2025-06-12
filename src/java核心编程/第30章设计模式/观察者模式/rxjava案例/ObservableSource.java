package java核心编程.第30章设计模式.观察者模式.rxjava案例;

/**
 * 被观察者接口
 */
public interface ObservableSource<T> {
    void subscribe(Observer<T> observer);
}
