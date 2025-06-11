package java核心编程.第15章泛型.泛型擦除.边界处的动作;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 日期 : 2020/12/5.
 * 创建 : xin.li
 * 描述 :
 */
class ArrayMaker<T> {
    private Class<T> tClass;

    public ArrayMaker(Class<T> tClass) {
        this.tClass = tClass;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size){
        return  (T[]) Array.newInstance(tClass, size);
    }


    public static void main(String[] args) {
        ArrayMaker<String> arrayMaker = new ArrayMaker<>(String.class);
        String[] strings = arrayMaker.create(10);
        System.out.println(Arrays.toString(strings));
    }
}
