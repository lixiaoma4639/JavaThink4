package java核心编程.第15章泛型.泛型方法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class GenericParams {

    public static <T> List<T> makeList(T... args){
        List<T> ts = new ArrayList<>();
        for (T t: args) {
            ts.add(t);
        }
        return ts;
    }

    public static void main(String[] args) {
        List<String> a = makeList("A");
        a.add("B");
        List<Integer> integers = makeList(1, 2, 3);
        List<String> strings = makeList("hello world ...".split(" "));
        List<Boolean> booleans = Arrays.asList(true, false, true);

        System.out.println(a);
        System.out.println(integers);
        System.out.println(strings);
        System.out.println(booleans);
    }
}
