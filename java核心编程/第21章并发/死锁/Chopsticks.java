package java核心编程.第21章并发.死锁;

/**
 * 日期 : 2020/12/29.
 * 创建 : xin.li
 * 描述 :
 */
class Chopsticks {
    private boolean take = false;
    public synchronized void take() throws InterruptedException {
        while (take) wait();
        take = true;
    }

    public synchronized void drop() throws InterruptedException {
        take = false;
        notify();
    }
}
