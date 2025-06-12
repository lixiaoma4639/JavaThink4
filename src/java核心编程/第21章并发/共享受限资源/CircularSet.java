package java核心编程.第21章并发.共享受限资源;

/**
 * 日期 : 2020/12/21.
 * 创建 : xin.li
 * 描述 :
 */
class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size) {
        array = new int[size];
        len = size;
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i){
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int value){
        for (int i = 0; i < len; i++) {
            if (array[i] == value) return true;
        }
        return false;
    }


}
