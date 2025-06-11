package java核心编程.第21章并发.定义任务;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/18.
 * 创建 : xin.li
 * 描述 :
 */
public class DaemonThreadPoolFactory extends ThreadPoolExecutor {

    public DaemonThreadPoolFactory() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>() , new DaemonThreadFactory());
    }
}
