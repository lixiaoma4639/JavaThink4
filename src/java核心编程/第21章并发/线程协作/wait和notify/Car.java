package java核心编程.第21章并发.线程协作.wait和notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/27.
 * 创建 : xin.li
 * 描述 :
 */
class Car {
    private boolean waxOn = false;

    public synchronized void waxed(){
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed(){
        waxOn = false;
        notifyAll();
    }

    public void setWaxOn(boolean waxOn) {
        this.waxOn = waxOn;
    }

    public synchronized void waitingForWaxing() throws InterruptedException {
        while (!waxOn){
            wait();
        }
    }
    public synchronized void waitingForBuffing() throws InterruptedException {
        while (waxOn){
            wait();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaxOn(car));
        executorService.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
