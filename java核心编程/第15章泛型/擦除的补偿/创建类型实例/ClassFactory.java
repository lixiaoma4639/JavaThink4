package java核心编程.第15章泛型.擦除的补偿.创建类型实例;

/**
 * 日期 : 2020/12/5.
 * 创建 : xin.li
 * 描述 :
 */
class ClassFactory<T> {
    private T t;

    public ClassFactory(Class<T> type) throws Exception{
        t = type.newInstance();
    }

    static class A{}

    public static void main(String[] args) {
        try {
            ClassFactory<A> classFactory = new ClassFactory<>(A.class);
            System.out.println("成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ClassFactory<Integer> classFactory = new ClassFactory<>(Integer.class);
            System.out.println("成功2");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败2");
        }
    }
}
