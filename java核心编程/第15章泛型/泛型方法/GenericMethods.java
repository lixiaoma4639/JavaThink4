package java核心编程.第15章泛型.泛型方法;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class GenericMethods {
    public <T> void f(T t){
        System.out.println(t.getClass().getSimpleName());
    }
}
