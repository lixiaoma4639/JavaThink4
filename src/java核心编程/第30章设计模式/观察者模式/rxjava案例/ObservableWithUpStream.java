package java核心编程.第30章设计模式.观察者模式.rxjava案例;

public abstract class ObservableWithUpStream<T, U> extends Observable<U>{

    protected ObservableSource<T> mObservableSource;

    public ObservableWithUpStream(ObservableSource<T> observableSource) {
        mObservableSource = observableSource;
    }

}
