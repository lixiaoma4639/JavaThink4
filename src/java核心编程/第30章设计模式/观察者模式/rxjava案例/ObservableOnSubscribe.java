package java核心编程.第30章设计模式.观察者模式.rxjava案例;


public interface ObservableOnSubscribe<T> {
    void subscribe(Emitter<T> emitter);
}
