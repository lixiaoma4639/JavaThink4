package java核心编程.第15章泛型.协变逆变;

import java.util.ArrayList;
import java.util.List;

import java核心编程.第15章泛型.通配符.CovariantArray;

/**
 * 日期 : 2020/12/6.
 * 创建 : xin.li
 * 描述 :
 */
class SuperType {
    public static void main1(String[] args) {
        SuperType.writTo(new ArrayList<>());
    }
    static void writTo(List<? super CovariantArray.A2> list){
        list.add(new CovariantArray.A2());
        list.add(new CovariantArray.A3());
        //error
        //list.add(new CovariantArray.A());
        System.out.println(list);
    }


    private static List<CovariantArray.A> a1s = new ArrayList<CovariantArray.A>();
    private static List<CovariantArray.A2> a2s = new ArrayList<CovariantArray.A2>();
    private static List<CovariantArray.A3> a3s = new ArrayList<CovariantArray.A3>();

    static void f(){
        writeExact(a2s , new CovariantArray.A2());
        writeExact(a1s , new CovariantArray.A2());
    }
    static <T> void writeExact(List<T> list , T item){
        list.add(item);
    }
    static void f2(){
        //error
        //writeExact2(a2s , new CovariantArray.A());
        writeExact2(a2s , new CovariantArray.A2());
        writeExact2(a2s , new CovariantArray.A3());

        writeExact2(a1s , new CovariantArray.A());
        writeExact2(a1s , new CovariantArray.A2());
        writeExact2(a1s , new CovariantArray.A3());
    }
    static <T> void writeExact2(List<? super T> list , T item){
        list.add(item);
        Object object = list.get(0);
        System.out.println(object);
    }

    static void writeExact3(List<? super CovariantArray.A2> list){
        //error
//        list.add(new CovariantArray.A());
        list.add(new CovariantArray.A2());
        list.add(new CovariantArray.A3());
    }

    static void writeExact4(List<? super Integer> list){
        //error
//        list.add(new CovariantArray.A());
        list.add(1);
        list.add(2);

        //类型转换安全
        Integer integer = (Integer) list.get(0);
        System.out.println(integer);
    }

    public static void main(String[] args) {
//        f();
//        f2();

//        writeExact3(a1s);
//        writeExact3(a2s);
        //error
//        writeExact3(a3s);

        writeExact4(new ArrayList<Integer>());
        writeExact4(new ArrayList<Number>());
    }
}
