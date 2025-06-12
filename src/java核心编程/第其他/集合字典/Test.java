package java核心编程.第其他.集合字典;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String, Integer> accessOrderMap = new LinkedHashMap<>(5, 0.75f, true);

        accessOrderMap.put("A", 1);
        accessOrderMap.put("B", 2);
        accessOrderMap.put("C", 3);

        System.out.println(accessOrderMap); // {A=1, B=2, C=3} - 初始插入顺序

        accessOrderMap.get("A"); // 访问A
//        accessOrderMap.get("B"); // 访问B

        System.out.println(accessOrderMap); // {C=3, A=1, B=2} - 最近访问的移到最后
    }
}
