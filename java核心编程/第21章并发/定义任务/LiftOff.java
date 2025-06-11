package java核心编程.第21章并发.定义任务;

/**
 * 日期 : 2020/12/17.
 * 创建 : xin.li
 * 描述 :
 */
public class LiftOff implements Runnable{

    protected int countDown = 10;
    private static int taskCount = 0;
    protected final int Id = taskCount++;

    public LiftOff() {
    }
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println("# " + Id + "(" + countDown + ") , ");
            Thread.yield();
        }
    }

    public static void main1(String[] args) {
        LiftOff liftOff = new LiftOff();
//        liftOff.run();
        Thread teThread = new Thread(liftOff);
        teThread.start();
        System.out.println("等待...");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("等待...");
    }
}
