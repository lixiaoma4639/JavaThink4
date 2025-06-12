package java核心编程.第15章泛型.简单泛型.元组;

/**
 * 日期 : 2020/12/4.
 * 创建 : xin.li
 * 描述 :
 */
public class FourTuple<A , B , C , D> extends ThreeTuple<A , B , C> {
    public final D four;


    public FourTuple(A first, B second, C c , D d) {
        super(first, second, c);
        this.four = d;
    }

    @Override
    public String toString() {
        return " { " + first + " , " + second + ", " + third + ", " + four  + " } ";
    }
}
