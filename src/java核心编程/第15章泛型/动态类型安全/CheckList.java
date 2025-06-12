package java核心编程.第15章泛型.动态类型安全;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 日期 : 2020/12/12.
 * 创建 : xin.li
 * 描述 :
 */
class CheckList {
    static class Pet{}
    static class Cat extends Pet{}
    static class Dog extends Pet{}

    static void oldMethod(List list){
        list.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        oldMethod(list);

        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        oldMethod(pets);

        List<Dog> list2 = new ArrayList<>();
        list2 = Collections.checkedList(list2, Dog.class);
        oldMethod(list2);
    }
}
