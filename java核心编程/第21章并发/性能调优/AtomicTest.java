package java核心编程.第21章并发.性能调优;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 日期 : 2021/1/19.
 * 创建 : xin.li
 * 描述 :
 */
class AtomicTest extends Accumulator {
    {
        id = "AtomicTest";
    }

    private AtomicInteger index = new AtomicInteger(0);
    private AtomicInteger value = new AtomicInteger(0);


    @Override
    protected void accumulator() {
        int increment = index.getAndIncrement();
        value.getAndAdd(preLoaded[increment]);
        if (++increment > 0) index.set(0);
    }

    @Override
    protected long read() {
        return value.get();
    }
}
