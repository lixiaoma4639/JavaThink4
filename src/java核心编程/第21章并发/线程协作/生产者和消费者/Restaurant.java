package java核心编程.第21章并发.线程协作.生产者和消费者;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 日期 : 2020/12/27.
 * 创建 : xin.li
 * 描述 :
 */
class Restaurant {
    Meal meal;
    ExecutorService executorService = Executors.newCachedThreadPool();
    final Chef chef = new Chef(this);
    final WaitPerson waitPerson  = new WaitPerson(this);

    public Restaurant() {
        executorService.execute(chef);
        executorService.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}
