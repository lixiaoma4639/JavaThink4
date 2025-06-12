package java核心编程.第15章泛型.擦除的补偿.创建类型实例;

/**
 * 日期 : 2020/12/5.
 * 创建 : xin.li
 * 描述 :
 */
abstract class GenericWithCreate<T> {
    final T element;

    public GenericWithCreate() {
        element = create();
    }

    public static void main(String[] args) {
        MyCreator myCreator = new MyCreator();
        myCreator.f();
    }

    abstract T create() ;

    static class XX{}

    static class MyCreator extends GenericWithCreate<XX>{

        @Override
        XX create() {
            return new XX();
        }

        void f(){
            System.out.println(element.getClass().getSimpleName());
        }
    }
}
