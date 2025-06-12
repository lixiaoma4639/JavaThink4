package java核心编程.第21章并发.线程协作.wait和notify;

import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/27.
 * 创建 : xin.li
 * 描述 :
 */
class WaxOn implements Runnable{
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.print("开始给汽车打蜡...  ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitingForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("被中断了, 退出...");
        }
        System.out.println("ending wax on task...");
    }
}
