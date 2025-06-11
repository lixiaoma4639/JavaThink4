package java核心编程.第15章泛型.简单泛型.元组;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
public class TupleTest {

    static TwoTuple<String , Integer> f(){
        return new TwoTuple<>("李鑫" , 28);
    }
    static ThreeTuple<Integer , Integer , Boolean> g(){
        return new ThreeTuple<>(1 , 2 , true);
    }

    public static FourTuple<Integer , Integer , Boolean , Double> h(){
        return new FourTuple<>(1 , 2 , true , 3.0);
    }


    public static void main(String[] args) {
        TwoTuple<String, Integer> f = f();
        ThreeTuple<Integer, Integer, Boolean> g = g();

        System.out.println(f);
        System.out.println(g);
    }
}
