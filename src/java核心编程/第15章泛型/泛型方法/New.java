package java核心编程.第15章泛型.泛型方法;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class New {
    public static <K , V> Map<K , V> map(){
        return new HashMap<>();
    }

    void f(Map<String, List<? extends Number>> map){}

    static void g(Map<String, List<? extends Number>> map){}

    public static void main(String[] args) {
        Map<String, List<? extends Number>> map = map();
        New n = new New();
        n.<String, List<Integer>>f(map);
        n.<String, List<Integer>>f(map());
        //显示的类型说明
        New.<String, List<Integer>>g(New.<String, List<? extends Number>>map());
    }
}
