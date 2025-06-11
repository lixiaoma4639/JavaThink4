package java核心编程.第15章泛型.简单泛型.元组;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class ThreeTuple<A , B , C> extends TwoTuple<A , B> {
    public final C third;
    public ThreeTuple(A first, B second, C c) {
        super(first, second);
        this.third = c;
    }

    @Override
    public String toString() {
        return " { " + first + " , " + second + ", " + third + " } ";
    }
}
