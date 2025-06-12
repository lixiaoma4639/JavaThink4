package java核心编程.第21章并发.线程协作.notif和notifyAll;

/**
 * 日期 : 2020/12/27.
 * 创建 : xin.li
 * 描述 :
 */
class Task1 implements Runnable {

    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
