package java核心编程.第14章类型信息.类型转换前检查;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 日期 : 2020/12/2.
 * 创建 : xin.li
 * 描述 :
 */
class TypeCounter extends LinkedHashMap<Class<?> , Integer> {
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj){
        Class<?> type = obj.getClass();
        //isAssignableFrom 判断type这个类型是不是baseType的子类型
        if (!baseType.isAssignableFrom(type)){
            throw new RuntimeException("obj 你的类型" + type + "不正确, 期望是" + baseType);
        }
        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer integer = get(type);
        put(type , integer == null ? 1 : integer + 1);
        Class<?> superclass = type.getSuperclass();
        if (superclass != null && baseType.isAssignableFrom(superclass)){
            countClass(superclass);
        }
    }

    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(A.class);
        typeCounter.count(new D());
//        System.out.println(typeCounter);

        TypeCounter typeCounter2 = new TypeCounter(Iterable.class);
        typeCounter2.count(new ArrayList<>());
        System.out.println(typeCounter2);

        System.out.println(new A().getClass().equals(A.class));
    }


    static class A {}
    static class B extends A {}
    static class C extends B {}
    static class D extends C {}



}
