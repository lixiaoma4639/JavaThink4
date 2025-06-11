package java核心编程.第21章并发.性能调优.免锁容器;

/**
 * 日期 : 2021/1/20.
 * 创建 : xin.li
 * 描述 :
 */
class ListComparator {
    public static void main(String[] args) {
        args = new String[]{"1" , "10" , "10"};
        Tester.initMain(args);
        new CopyOnWriteArrayListTest(10 , 0);
        new CopyOnWriteArrayListTest(9 , 1);
        new CopyOnWriteArrayListTest(5 , 5);
        new SynchronizedArrayListTest(10 , 0);
        new SynchronizedArrayListTest(9 , 1);
        new SynchronizedArrayListTest(5 , 5);
        Tester.exec.shutdownNow();
    }
}
