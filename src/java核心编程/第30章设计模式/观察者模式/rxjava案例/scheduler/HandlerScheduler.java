package java核心编程.第30章设计模式.观察者模式.rxjava案例.scheduler;

import java.util.concurrent.Executor;

public class HandlerScheduler extends Scheduler{

    private final Executor mExecutor;

    public HandlerScheduler(Executor executor) {
        mExecutor = executor;
    }

    @Override
    public Worker createWorker() {
        return new HandlerWorker(mExecutor);
    }

    static final class HandlerWorker implements Worker{
        private final Executor workerThread;

        public HandlerWorker(Executor thread) {
            workerThread = thread;
        }

        @Override
        public void schedule(Runnable runnable) {
            workerThread.execute(runnable);
        }
    }
}
