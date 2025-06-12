package java核心编程.第21章并发.共享受限资源;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 日期 : 2020/12/21.
 * 创建 : xin.li
 * 描述 :
 */
public class MutexEvenGenerator extends IntGenerator{
    private int currentEvenValue ;
    private Lock lock = new ReentrantLock();


    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }
}
