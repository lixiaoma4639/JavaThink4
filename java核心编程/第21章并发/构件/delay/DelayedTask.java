package java核心编程.第21章并发.构件.delay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 日期 : 2021/1/15.
 * 创建 : xin.li
 * 描述 :
 */
class DelayedTask implements Runnable , Delayed {


    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;

    protected static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int delayMill) {
        this.delta = delayMill;
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delayMill , TimeUnit.MILLISECONDS);
        sequence.add(this);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedTask that = (DelayedTask) o;
        if (trigger < that.trigger) return -1;
        if (trigger > that.trigger) return 1;
        return 0;
    }

    @Override
    public void run() {
        System.out.println(this + " 父类...");
    }

    @Override
    public String toString() {
        return String.format("DelayedTask %1$-4d" , delta) + " task " + id;
    }

    public String summary(){
        return "-(" + id + " : " + delta + ")-";
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long convert = unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
        System.out.println("到期时间: " + convert);
        return convert;
    }


    public static class EndSentinel extends DelayedTask{
        ExecutorService executorService;

        public EndSentinel(int delayMill, ExecutorService executorService) {
            super(delayMill);
            this.executorService = executorService;
        }

        @Override
        public void run() {
            for (DelayedTask d : sequence) {
                System.out.println(d.summary() + " 这里...");
            }
            System.out.println(this + " 停止...");
            executorService.shutdownNow();
        }
    }
}
