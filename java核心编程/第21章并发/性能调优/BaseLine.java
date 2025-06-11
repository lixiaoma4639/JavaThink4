package java核心编程.第21章并发.性能调优;

/**
 * 日期 : 2021/1/19.
 * 创建 : xin.li
 * 描述 :
 */
class BaseLine extends Accumulator {

    {
        id = "BaseLine";
    }


    @Override
    protected void accumulator() {
        if (index >= SIZE) index = 0;
        value += preLoaded[index++];
    }

    @Override
    protected long read() {
        return value;
    }
}
