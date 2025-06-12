package java核心编程.第30章设计模式.观察者模式.rxjava案例;

public class ObservableMap<T, U> extends ObservableWithUpStream<T, U>{

    Function<T, U> mFunction;

    public ObservableMap(ObservableSource<T> observableSource, Function<T, U> fun) {
        super(observableSource);
        this.mFunction = fun;
    }

    @Override
    protected void subscribeActual(Observer<U> observer) {
        mObservableSource.subscribe(new MapObserver<>(observer, mFunction));
    }


    static class MapObserver<T, U> implements Observer<T>{

        Observer<U> downStream;
        Function<T, U> mMapFun;

        public MapObserver(Observer<U> downStream, Function<T, U> mapFun) {
            this.downStream = downStream;
            mMapFun = mapFun;
        }

        @Override
        public void onSubscribe() {
            downStream.onSubscribe();
        }

        @Override
        public void onNext(T t) {
            U u = mMapFun.apply(t);
            downStream.onNext(u);
        }

        @Override
        public void onError(Throwable e) {
            downStream.onError(e);
        }

        @Override
        public void onComplete() {
            downStream.onComplete();
        }
    }
}
