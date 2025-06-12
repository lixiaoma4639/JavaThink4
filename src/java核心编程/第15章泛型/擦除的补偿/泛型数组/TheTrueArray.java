package java核心编程.第15章泛型.擦除的补偿.泛型数组;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 日期 : 2020/12/6.
 * 创建 : xin.li
 * 描述 :
 */
class TheTrueArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public TheTrueArray(Class<T> tClass , int size) {
        //正确的泛型数组使用方法
        array  = (T[]) Array.newInstance(tClass, size);
    }

    public void put(int index , T element){
        array[index] = element;
    }


    public T get(int index) {
        return array[index];
    }

    public T[] getArray() {
        return array;
    }

    public static void main(String[] args) {
        TheTrueArray<Integer> integers = new TheTrueArray<>(Integer.class , 10);
        integers.put(0 , 3);
        integers.put(1 , 5);
//        integers.put(2 , "A");
        System.out.println(Arrays.toString(integers.getArray()));

        new ArrayList<String>();
    }


}
