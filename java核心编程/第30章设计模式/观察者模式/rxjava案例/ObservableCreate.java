package java核心编程.第30章设计模式.观察者模式.rxjava案例;

/**
 * 被观察者的实现类
 * @param <T>
 */
public class ObservableCreate<T> extends Observable<T>{

    ObservableOnSubscribe<T> mOnSubscribe;

    public ObservableCreate(ObservableOnSubscribe<T> onSubscribe) {
        mOnSubscribe = onSubscribe;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        observer.onSubscribe();
        CreateEmitter<T> tCreateEmitter = new CreateEmitter<>(observer);
        mOnSubscribe.subscribe(tCreateEmitter);
    }


    static class CreateEmitter<T> implements Emitter<T>{
        Observer<T> observer;
        boolean done;

        public CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T s) {
            if (done) {
                return;
            }
            observer.onNext(s);
        }

        @Override
        public void onError(Throwable e) {
            if (done) {
                return;
            }
            observer.onError(e);
            done =true;
        }

        @Override
        public void onComplete() {
            if (done) {
                return;
            }
            observer.onComplete();
            done =true;
        }
    }
}
