package java核心编程.第21章并发.性能调优.免锁容器;

import java.util.List;

/**
 * 日期 : 2021/1/20.
 * 创建 : xin.li
 * 描述 :
 */
abstract class ListTest extends Tester<List<Integer>> {

    public ListTest(String testId, int nReads, int nWrites) {
        super(testId, nReads, nWrites);
    }

    @Override
    void startReadAndWrite() {
        for (int i = 0; i < nReads; i++) {
            exec.execute(new Reader());
        }
        for (int i = 0; i < nWrites; i++) {
            exec.execute(new Writer());
        }
    }

    class Reader extends TestTask{

        long result = 0;

        @Override
        void test() {
            for (long i = 0; i < testCycles; i++) {
                for (int index = 0; index < containerSize ; index++) {
                    result += testContainer.get(index);
                }
            }
        }

        @Override
        void putResults() {
            readResult += result;
            readTime += duration;
        }
    }

    class Writer extends TestTask{

        @Override
        void test() {
            for (long i = 0; i < testCycles; i++) {
                for (int index = 0; index < containerSize ; index++) {
                    testContainer.set(index , writeData[index]);
                }
            }
        }

        @Override
        void putResults() {
            writeTime += duration;
        }
    }

}
