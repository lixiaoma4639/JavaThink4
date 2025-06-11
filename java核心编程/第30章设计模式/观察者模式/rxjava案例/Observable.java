package java核心编程.第30章设计模式.观察者模式.rxjava案例;

import java核心编程.第30章设计模式.观察者模式.rxjava案例.scheduler.Scheduler;

/**
 * 被观察者
 */
public abstract class Observable<T> implements ObservableSource<T>{

    @Override
    public void subscribe(Observer<T> observer) {
        //建立订阅
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<T> observer);


    public static <E> Observable<E> create(ObservableOnSubscribe<E> subscribe){
        return new ObservableCreate<>(subscribe);
    }

    public <R> ObservableMap<T, R> map(Function<T, R> function){
        return new ObservableMap<>(this, function);
    }

    public ObservableSubscribeON<T> subscribeOn(Scheduler scheduler){
        return new ObservableSubscribeON<>(this, scheduler);
    }
}
