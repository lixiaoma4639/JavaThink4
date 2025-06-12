package java核心编程.第30章设计模式.观察者模式.rxjava案例.scheduler;


public abstract class Scheduler {

    public abstract Worker createWorker();

    public interface Worker{
        void schedule(Runnable runnable);
    }
}
