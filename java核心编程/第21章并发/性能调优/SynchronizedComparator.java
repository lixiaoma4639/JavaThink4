package java核心编程.第21章并发.性能调优;

/**
 * 日期 : 2021/1/19.
 * 创建 : xin.li
 * 描述 :
 */
class SynchronizedComparator {
    private static BaseLine baseLine = new BaseLine();
    private static SynchronizingTest synchronizingTest = new SynchronizingTest();
    private static LockTest lockTest = new LockTest();
    private static AtomicTest atomicTest = new AtomicTest();
    static void test(){
        System.out.println("=======================");
        System.out.println(String.format("%-2s : %13d" , "cycles" , Accumulator.cycles));
        baseLine.timedTest();
        synchronizingTest.timedTest();
        lockTest.timedTest();
        atomicTest.timedTest();

        Accumulator.report(synchronizingTest , baseLine);
        Accumulator.report(lockTest , baseLine);
        Accumulator.report(atomicTest , baseLine);
        Accumulator.report(synchronizingTest , lockTest);
        Accumulator.report(synchronizingTest , atomicTest);
        Accumulator.report(lockTest , atomicTest);
    }

    public static void main(String[] args) {
        int aaa = 5;
        baseLine.timedTest();
        for (int i = 0; i < aaa; i++) {
            test();
            Accumulator.cycles *= 2;
        }
        Accumulator.exec.shutdownNow();
    }
}
