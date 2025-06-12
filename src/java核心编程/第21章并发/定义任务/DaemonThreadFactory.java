package java核心编程.第21章并发.定义任务;

import java.util.concurrent.ThreadFactory;

/**
 * 日期 : 2020/12/18.
 * 创建 : xin.li
 * 描述 :
 */
class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
