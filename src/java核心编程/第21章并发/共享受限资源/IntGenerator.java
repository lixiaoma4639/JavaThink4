package java核心编程.第21章并发.共享受限资源;

/**
 * 日期 : 2020/12/20.
 * 创建 : xin.li
 * 描述 :
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel(){
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
