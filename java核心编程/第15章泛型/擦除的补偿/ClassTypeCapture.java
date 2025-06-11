package java核心编程.第15章泛型.擦除的补偿;

/**
 * 日期 : 2020/12/5.
 * 创建 : xin.li
 * 描述 : type.isInstance(o) 弥补类型擦除 无法使用 object instanceOf T
 */
class ClassTypeCapture<T> {

    //类型标签
    private Class<T> type;

    public ClassTypeCapture(Class<T> type) {
        this.type = type;
    }

    public boolean f(Object o){
        //type.isInstance(o) 弥补类型擦除 无法使用 object instanceOf T
        return type.isInstance(o);
    }

    public static void main(String[] args) {
        ClassTypeCapture<A> classTypeCapture = new ClassTypeCapture<>(A.class);

        System.out.println(classTypeCapture.f(new A()));
        System.out.println(classTypeCapture.f(new AChild()));

        ClassTypeCapture<AChild> classTypeCapture2 = new ClassTypeCapture<>(AChild.class);

        System.out.println(classTypeCapture2.f(new A()));
        System.out.println(classTypeCapture2.f(new AChild()));

    }

    static class A{}
    static class AChild extends A{}
}
