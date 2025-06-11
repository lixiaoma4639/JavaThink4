package java核心编程.第15章泛型.混型;

/**
 * 日期 : 2020/12/12.
 * 创建 : xin.li
 * 描述 :
 */
interface SerialNumber {
    long getSerialNumber();

    static class SerialNumberImpl implements SerialNumber{

        private static  long SS = 1;

        private final long count = SS++;

        @Override
        public long getSerialNumber() {
            return count;
        }
    }
}
