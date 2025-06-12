package java核心编程.第21章并发.线程协作.生产者和消费者;

import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2020/12/27.
 * 创建 : xin.li
 * 描述 :
 */
class Chef implements Runnable {

    Restaurant restaurant;

    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.meal != null){
                        wait();
                    }
                }
                if (++count == 10){
                    System.out.println("out of foot, close. ..");
                    restaurant.executorService.shutdownNow();
                }
                System.out.println("order up!" );
                synchronized (restaurant.waitPerson){
                    System.out.println("做饭..." );
                    restaurant.meal = new Meal(10);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("chef Interrupted Exception");
        }
    }
}
