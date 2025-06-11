package java核心编程.第14章类型信息.类型转换前检查;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 日期 : 2020/12/2.
 * 创建 : xin.li
 * 描述 :
 */
class 动态instanceOf {
    private static Map<Class<? extends Number> , Integer> map = new LinkedHashMap<>();

    static {
        map.put(Integer.class , 1);
        map.put(Double.class , 2);
        map.put(Long.class , 3);
    }

    static {
        map.put(Float.class , 4);
    }

    public static void main(String[] args) {

        count(2l);
        count(2);
        count(2d);

        System.out.println(map);


    }

    private static void count(Number a){
        Set<Map.Entry<Class<? extends Number>, Integer>> entries = map.entrySet();
        for (Map.Entry<Class<? extends Number>, Integer> item : entries) {
            if (item.getKey().isInstance(a)){
                map.put(item.getKey() , item.getValue() + 1);
            }
        }
    }
}
