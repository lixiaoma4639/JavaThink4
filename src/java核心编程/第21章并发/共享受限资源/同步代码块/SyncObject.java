package java核心编程.第21章并发.共享受限资源.同步代码块;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2021/1/22.
 * 创建 : xin.li
 * 描述 : 同步代码块, 也叫临界区
 */
class SyncObject {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        SyncObject syncObject = new SyncObject();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                syncObject.methodA();
                syncObject.methodB();
                syncObject.methodC();
                syncObject.methodC();
                syncObject.methodC();
                syncObject.methodC();
            }
        });
    }

    public synchronized void methodA(){
        System.out.println("method a ...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB(){
        synchronized (this){
            System.out.println("b....");
        }
    }

    private String hi;
    public void methodC(){
        if (hi == null){
            synchronized (this){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("c....");
                hi = "hello world...";
            }
        }
        System.out.println("c " + hi);
    }
}
