package java核心编程.第15章泛型.擦除的补偿.创建类型实例;

/**
 * 日期 : 2020/12/5.
 * 创建 : xin.li
 * 描述 :
 */
class Foo<T> {
    private T x;

    //<F extends MyFactory<T>> 声明的意思是,传递进入的 myFactory 参数必须实现 MyFactory接口
    public <F extends IFactory<T>> Foo(F myFactory){
        x = myFactory.create();
    }

    public T get() {
        return x;
    }

    public static void main(String[] args) {
        Foo<Integer> integerFoo = new Foo<>(new IntegerFactory());
        System.out.println(integerFoo.get());

        Foo<Widget> widgetFoo = new Foo<>(new Widget.MyFactory());
        System.out.println(widgetFoo.get());
    }
}
