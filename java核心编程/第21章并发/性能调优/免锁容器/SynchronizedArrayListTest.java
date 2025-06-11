package java核心编程.第21章并发.性能调优.免锁容器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 日期 : 2021/1/20.
 * 创建 : xin.li
 * 描述 :
 */
class SynchronizedArrayListTest extends ListTest {

    public SynchronizedArrayListTest(int nReads, int nWrites) {
        super("SynchronizedArrayListTest", nReads, nWrites);
    }

    @Override
    List<Integer> containerInit() {
        return Collections.synchronizedList(new ArrayList<Integer>(
                new CountingIntegerList(containerSize)
        ));
    }


}
