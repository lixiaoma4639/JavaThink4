package java核心编程.第21章并发.共享受限资源;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 日期 : 2020/12/21.
 * 创建 : xin.li
 * 描述 :
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    private void unTimed(){
        boolean b = lock.tryLock();
        try {
            System.out.println("tryLock " + b);
        } finally {
            if (b) lock.unlock();
        }

    }

    public void timed(){
        boolean b = false;
        try {
            b = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock2 " + b);
        } finally {
            if (b) lock.unlock();
        }
    }

    public static void main(String[] args) {
        AttemptLocking attemptLocking = new AttemptLocking();
        attemptLocking.unTimed();
        attemptLocking.timed();
        new Thread(){
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                attemptLocking.lock.lock();
                System.out.println("acquired...");
            }
        }.start();
        Thread.yield();
        attemptLocking.unTimed();
        attemptLocking.timed();
    }
}
