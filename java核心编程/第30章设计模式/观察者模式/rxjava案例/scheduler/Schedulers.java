package java核心编程.第30章设计模式.观察者模式.rxjava案例.scheduler;

import java.util.concurrent.Executors;

public class Schedulers {

    private static Scheduler IO = null;
    private static Scheduler MAIN = null;
    static {
        IO = new HandlerScheduler(Executors.newFixedThreadPool(5));
        MAIN = new HandlerScheduler(Executors.newFixedThreadPool(5));
    }

    public static Scheduler ioThread(){
        return IO;
    }

    public static Scheduler mainThread(){
        return MAIN;
    }
}
