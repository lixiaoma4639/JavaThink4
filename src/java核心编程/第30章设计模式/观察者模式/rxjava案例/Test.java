package java核心编程.第30章设计模式.观察者模式.rxjava案例;

import java核心编程.第30章设计模式.观察者模式.rxjava案例.scheduler.Schedulers;

public class Test {

    public static void main(String[] args) {
        new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程是 = " + Thread.currentThread());
                System.out.println("执行run");
            }
        }.run();

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Emitter<String> emitter) {
                System.out.println("当前线程是 = " + Thread.currentThread());
                emitter.onNext("111");
                emitter.onNext("222");
                emitter.onError(new Exception("报错了。。。"));
                emitter.onComplete();
            }
        }).map(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                System.out.println("当前线程是 = " + Thread.currentThread());
                return "s" + "，做了map操作。。。";
            }
        }).subscribeOn(Schedulers.ioThread()).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe() {
                System.out.println("开启了。。。");
            }

            @Override
            public void onNext(Object s) {
                System.out.println("成功了， string = " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("报错了， error = " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("完成了。。。");
            }
        });
    }


    public static void main2(String[] args) {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Emitter<String> emitter) {
                emitter.onNext("111");
                emitter.onNext("222");
                emitter.onError(new Exception("报错了。。。"));
                emitter.onComplete();
            }
        }).map(new Function<String, Object>() {
                @Override
                public Object apply(String s) {
                    return "s" + "，做了map操作。。。";
                }
        }).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe() {
                System.out.println("开启了。。。");
            }

            @Override
            public void onNext(Object s) {
                System.out.println("成功了， string = " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("报错了， error = " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("完成了。。。");
            }
        });
    }
}
