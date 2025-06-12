package java核心编程.第21章并发.性能调优.免锁容器;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 日期 : 2021/1/20.
 * 创建 : xin.li
 * 描述 :
 */
class CopyOnWriteArrayListTest extends ListTest {
    public CopyOnWriteArrayListTest(int nReads, int nWrites) {
        super("CopyOnWriteArrayListTest", nReads, nWrites);
    }

    @Override
    List<Integer> containerInit() {
        return new CopyOnWriteArrayList<Integer>(
                new CountingIntegerList(containerSize)
        );
    }
}
