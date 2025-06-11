package java核心编程.第21章并发.性能调优;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 日期 : 2021/1/19.
 * 创建 : xin.li
 * 描述 :
 */
class LockTest extends Accumulator {
    {
        id = "LockTest";
    }

    private Lock lock = new ReentrantLock();

    @Override
    protected void accumulator() {
        lock.lock();
        try {
            value += preLoaded[index++];
            if (index >= SIZE) index = 0;
        } finally {
            lock.unlock();
        }
    }

    @Override
    protected long read() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}
