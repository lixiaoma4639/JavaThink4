package java核心编程.第21章并发.性能调优.免锁容器;

import java.util.AbstractList;

/**
 * 日期 : 2021/1/20.
 * 创建 : xin.li
 * 描述 :
 */
public class CountingIntegerList
        extends AbstractList<Integer> {
    private int size;

    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    public Integer get(int index) {
        return Integer.valueOf(index);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(30));
    }
}
