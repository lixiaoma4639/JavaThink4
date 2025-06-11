package java核心编程.第15章泛型.擦除的补偿.泛型数组;

/**
 * 日期 : 2020/12/5.
 * 创建 : xin.li
 * 描述 :
 */
public class GenericArray<T> {
    private T[] array;

    public GenericArray(int size) {
        this.array = (T[]) new Object[size];
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
        GenericArray<Integer> genericArray = new GenericArray<>(10);
        //error
//        Integer[] array1 = genericArray.getArray();
        Object[] array = genericArray.getArray();
    }
}
