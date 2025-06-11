package java核心编程.第15章泛型.简单泛型.元组;


/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
public class TwoTuple<T , E> {
    public final T first ;
    public final E second ;

    public TwoTuple(T first, E second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return " { " + first + " , " + second + " } ";
    }
}
