package java核心编程.第15章泛型.问题;

import java核心编程.第15章泛型.泛型接口.Generator;

/**
 * 日期 : 2020/12/8.
 * 创建 : xin.li
 * 描述 :
 */
class FArray {
    public static <T> T[] fill(T[] a , Generator<T> generator){
        for (int i = 0; i < a.length; i++) {
            a[i] = generator.next();
        }
        return a;
    }

    public static void main(String[] args) {
//        FArray.fill(new String[7] , new RandomG)
    }
}
