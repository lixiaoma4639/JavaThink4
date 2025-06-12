package java核心编程.第15章泛型.协变逆变.例子;

/**
 * 日期 : 2021/6/24.
 * 创建 : xin.li
 * 描述 :
 */
class Base {
    private static class Derived extends Base {}

    interface OrdinaryGetter {
        Base get();
    }

    interface DerivedGetter extends OrdinaryGetter {
        Derived get();
    }

    public class CovariantReturnTypes {
        void test(DerivedGetter d) {
            Derived d2 = d.get();
        }
    }

    //继承 自定义类型基类 的子类 将产生确切的子类型作为其返回值，就像上面的get()一样。
    interface GenericsGetter<T extends GenericsGetter<T>> {
        T get();
    }

    interface Getter extends GenericsGetter<Getter> {}

    public class GenericsAndReturnTypes {
        void test(Getter g) {
            Getter result = g.get();
            GenericsGetter genericsGetter = g.get();
        }
    }


    //在非泛型代码中，参数类型不能随子类型发生变化。方法只能重载不能重写。见下面代码示例。
    static class OrdinarySetter {
        void set(Base base) {
            System.out.println("OrdinarySetter.set(Base)");
        }
    }

    class DerivedSetter {
        void set(Base base) {
        }

        void set(Derived derived) {
            System.out.println("DerivedSetter.set(Derived)");
        }
    }


    interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
        void set(T args);
    }
    interface Setter extends SelfBoundSetter<Setter> {}
    public class SelfBoundAndCovariantArguments {
        void testA(Setter s1, Setter s2, SelfBoundSetter<Setter> sbs) {
            s1.set(s2);
            //s1.set(sbs);  // 编译错误
        }
    }










}
