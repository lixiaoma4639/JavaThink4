package java核心编程.第15章泛型.泛型擦除.神秘之处;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日期 : 2020/12/4.
 * 创建 : xin.li
 * 描述 :
 */
class ErasedType {

    public static void main1(String[] args) {
        Class<? extends ArrayList> aClass = new ArrayList<String>().getClass();
        Class<? extends ArrayList> aClass1 = new ArrayList<Integer>().getClass();
        System.out.println(aClass == aClass1);
        System.out.println(aClass.equals(aClass1));
        System.out.println(aClass);
        System.out.println(aClass1);
        System.out.println(aClass1.toGenericString());
        System.out.println(aClass1.toString());
    }

    public static void main(String[] args) {
        ArrayList<A> as = new ArrayList<>();
        HashMap<A, B> abHashMap = new HashMap<>();
        Q<A> aq = new Q<>();
        D<String, Integer> stringIntegerD = new D<>();


        System.out.println(Arrays.toString(as.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(abHashMap.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(aq.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(stringIntegerD.getClass().getTypeParameters()));
    }

    static class A {}
    static class B {}
    static class Q<T> {}
    static class D<First , Last> {}
}
