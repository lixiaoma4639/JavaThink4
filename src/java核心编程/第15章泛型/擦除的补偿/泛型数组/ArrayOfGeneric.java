package java核心编程.第15章泛型.擦除的补偿.泛型数组;

/**
 * 日期 : 2020/12/5.
 * 创建 : xin.li
 * 描述 :
 */
class ArrayOfGeneric {
    private static final int size = 10;
    static GenericTest<Integer>[] generators;

    static class GenericTest<T>{}

    public static void main(String[] args) {
        //error
//        generators = (GenericTest<Integer>[]) new Object[size];

        generators = (GenericTest<Integer>[]) new GenericTest[size];
        System.out.println(generators.getClass().getSimpleName());

        generators[0] = new GenericTest<>();


        Object[] objects = new Object[5];
        objects[0] = new GenericTest<Integer>();
        System.out.println(objects);

        String[] strs = (String[]) new Object[5];

    }
}
