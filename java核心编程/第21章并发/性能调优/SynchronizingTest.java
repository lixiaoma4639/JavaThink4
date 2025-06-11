package java核心编程.第21章并发.性能调优;

/**
 * 日期 : 2021/1/19.
 * 创建 : xin.li
 * 描述 :
 */
class SynchronizingTest extends Accumulator {
    {
        id = "SynchronizingTest";
    }


    @Override
    protected synchronized void accumulator() {
        value += preLoaded[index++];
        if (index >= SIZE) index = 0;
    }

    @Override
    protected synchronized long read() {
        return value;
    }
}
