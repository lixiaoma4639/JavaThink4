package java核心编程.第21章并发.线程协作.wait和notify;

/**
 * 日期 : 2020/12/27.
 * 创建 : xin.li
 * 描述 :
 */
class WaitText {
    public static void main(String[] args) {
        synchronized (WaitText.class){
            try {
                args.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
