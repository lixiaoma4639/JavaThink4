package java核心编程.第21章并发.构件.priority;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;



/**
 * 日期 : 2021/1/15.
 * 创建 : xin.li
 * 描述 :
 */
class PrioritizedTask implements Runnable , Comparable<PrioritizedTask>{

    private static int counter = 0;
    private final int id = counter++;
    private static Random random = new Random(47);
    private final int priority;
    private static List<PrioritizedTask> sequence = new ArrayList<>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(250));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("PrioritizedTask %1$-4d" , priority) + " task " + id;
    }

    public String summary(){
        return "-(" + priority + " : " + id + ")-";
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return Integer.compare(o.priority, priority);
    }


    public static class EndSentinel extends PrioritizedTask {
        ExecutorService executorService;

        public EndSentinel(ExecutorService executorService) {
            super(-1);
            this.executorService = executorService;
        }

        @Override
        public void run() {
            int count = 0 ;
            for (PrioritizedTask d : sequence) {
                System.out.println(d.summary() );
                if (++count % 5 == 0) System.out.println();
            }
            System.out.println();
//            System.out.println(this + " 停止...");
//            executorService.shutdownNow();
        }
    }
}
