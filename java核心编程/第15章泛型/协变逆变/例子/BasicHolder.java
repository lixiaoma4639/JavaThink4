package java核心编程.第15章泛型.协变逆变.例子;

/**
 * 日期 : 2021/6/24.
 * 创建 : xin.li
 * 描述 :
 */
class BasicHolder<T> {
    T element;

    void set(T arg) {
        element = arg;
    }

    T get() {
        return element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }

    static class Subtype extends BasicHolder<Subtype> {
    }

    public static void main(String[] args) {
        BasicHolder<Subtype> st1 = new Subtype();
        Subtype st2 = new Subtype();
        st1.set(st2);
        Subtype st3 = st1.get();
        st1.f();
    }
}
