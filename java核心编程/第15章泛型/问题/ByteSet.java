package java核心编程.第15章泛型.问题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 日期 : 2020/12/8.
 * 创建 : xin.li
 * 描述 :
 */
class ByteSet {

    public static void main(String[] args) {
        Byte[] bytes = {1 , 2 ,3 ,4 ,5, 6 , 7 ,8 ,9};
        Set<Byte> set = new HashSet<>(Arrays.asList(bytes));

//        Set<Byte> set2 = new HashSet<>(Arrays.asList(1 , 2 ,3 ,4 ,5, 6 , 7 ,8 ,9));
    }
}
