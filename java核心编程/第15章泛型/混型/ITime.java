package java核心编程.第15章泛型.混型;

import java.util.Date;

/**
 * 日期 : 2020/12/12.
 * 创建 : xin.li
 * 描述 :
 */
interface ITime {
    long getTime();

    static class ITimeImpl implements ITime{

        long time;

        public ITimeImpl() {
            time = new Date().getTime();
        }

        @Override
        public long getTime() {
            return time;
        }
    }
}
