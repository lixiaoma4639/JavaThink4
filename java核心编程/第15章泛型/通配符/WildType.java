package java核心编程.第15章泛型.通配符;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期 : 2020/12/7.
 * 创建 : xin.li
 * 描述 :
 */
class WildType {
    List list1;
    List<?> list2;
    List<? extends Object> list3;

    public void f1(List list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }
    public void f2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }
    public void f3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }



    public static void main(String[] args) {
        WildType wildType = new WildType();
        wildType.f1(new ArrayList());
        wildType.f2(new ArrayList());
        wildType.f3(new ArrayList());

        wildType.f1(new ArrayList<String>());
        wildType.f2(new ArrayList<String>());
        wildType.f3(new ArrayList<String>());

        List<?> list = new ArrayList<>();
        list = new ArrayList<String>();
        wildType.f1(list);
        wildType.f2(list);
        wildType.f3(list);
    }
}
