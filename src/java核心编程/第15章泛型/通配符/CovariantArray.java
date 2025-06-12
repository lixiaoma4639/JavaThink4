package java核心编程.第15章泛型.通配符;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 日期 : 2020/12/6.
 * 创建 : xin.li
 * 描述 :
 */
public class CovariantArray {
    Number[] numbers = new Integer[10];
    public static class A{}
    public static class A2 extends A {}
    public static class A3 extends A2{}
    public static class A4 extends A{}
    public static class A5 extends A3{}

    public static void main(String[] args) {
        List<? extends A> list = new ArrayList<A2>();
        //error
//        list.add(new A2());
//        list.add(new A());
//        list.add(new Object());
        list.add(null);
        A a = list.get(0);

//        List<? extends A> list2 = Arrays.asList(new A2());
//        A aObj = list2.get(0);
//        A2 a2 = (A2) list2.get(0);
//
//        System.out.println(aObj);
//        System.out.println(a2);;
//        System.out.println(list2.contains(new A2()));
//        System.out.println(list2.indexOf(new A2()));



        List<? extends A2>  datas = new ArrayList<>(Arrays.asList(new A2() , new A2() , new A3()));
        for (int i = 0; i < datas.size(); i++) {
            System.out.println(datas.get(i));
        }
        A2 a1 = (A2) datas.get(0);
        //error
       //datas.add(new A());
       //datas.add(new A2());

    }

    public static void main2(String[] args) {
        //下面的这个数组在编译器是可以存放 A和其子类 / A2和其子类
        //但是在运行期数组里面只能存放 A2和其子类 , 如果存放的不是,则抛出ArrayStoreException  数组存放异常
        A[] as = new A2[10];
        as[0] = new A2();
        as[1] = new A3();

       // as[2] = new A();
       // as[3] = new A4();

    }
}
