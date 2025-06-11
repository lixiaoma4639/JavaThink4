package java核心编程.第15章泛型.通配符;

/**
 * 日期 : 2020/12/8.
 * 创建 : xin.li
 * 描述 :
 */
class CaptureCon {

    public static <T> void f1(Holder<T> holder){
        T t = holder.getT();
        System.out.println(t.getClass().getSimpleName());
    }

    public static  void f2(Holder<?> holder){
        //捕获转换,到这里的时候就已经知道?具体是什么类型了, 因此调用已知参数类型方法f1是安全的
        f1(holder);
    }

    public static void main(String[] args) {
        Holder integerHolder = new Holder<Integer>(1);
        f1(integerHolder);
        f2(integerHolder);

        Holder rawHolder = new Holder();
        rawHolder.setT(1L);
        f2(rawHolder);
//
        Holder<?> wildHolder = new Holder<Double>(1.0);
        f2(wildHolder);

    }
}
