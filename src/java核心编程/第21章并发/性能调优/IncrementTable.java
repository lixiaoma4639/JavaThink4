package java核心编程.第21章并发.性能调优;

/**
 * 日期 : 2021/1/19.
 * 创建 : xin.li
 * 描述 :
 */
abstract class IncrementTable {
    protected long counter = 0;
    public abstract void increment();
}
