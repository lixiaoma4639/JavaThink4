package java核心编程.第21章并发.共享受限资源;

/**
 * 日期 : 2020/12/20.
 * 创建 : xin.li
 * 描述 :
 */
class EvenGenerator extends IntGenerator {

    private int currentEven = 0 ;


    @Override
    public synchronized int next() {
        ++currentEven;
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread.yield();
        ++currentEven;
        return currentEven;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
