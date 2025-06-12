package java核心编程.第30章设计模式.观察者模式.rxjava案例;

import java核心编程.第30章设计模式.观察者模式.rxjava案例.scheduler.Scheduler;

public class ObservableSubscribeON<T> extends ObservableWithUpStream<T, T>{

    final Scheduler mScheduler;

    public ObservableSubscribeON(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        mScheduler = scheduler;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        Scheduler.Worker worker = mScheduler.createWorker();
        worker.schedule(new SubscribeTask(new SubscribeOnObserver<>(observer)));
    }

    static class SubscribeOnObserver<T> implements Observer<T>{

        Observer<T> downStream;

        public SubscribeOnObserver(Observer<T> downStream) {
            this.downStream = downStream;
        }

        @Override
        public void onSubscribe() {
            downStream.onSubscribe();
        }

        @Override
        public void onNext(T t) {
            downStream.onNext(t);
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


    final class SubscribeTask implements Runnable{

        private SubscribeOnObserver<T> parent;

        public SubscribeTask(SubscribeOnObserver<T> parent) {
            this.parent = parent;
        }

        @Override
        public void run() {
            //mObservableSource是ObservableMap，parent是SubscribeOnObserver，这个观察者是在这里这个线程中进行观察的
            mObservableSource.subscribe(parent);
        }
    }
}
