package java核心编程.第15章泛型.自限定类型;

/**
 * 日期 : 2020/12/10.
 * 创建 : xin.li
 * 描述 :
 */
class SelfBound<T extends SelfBound<T>> {


    T element;

    public T getElement() {
        return element;
    }

    public SelfBound<T> setElement(T element) {
        this.element = element;
        return this;
    }

    public static <E extends SelfBound<E>> E f(E element){
        return element.setElement(element).getElement();
    }

    public static void main(String[] args) {

    }


    static class A extends SelfBound<A>{}
    static class B extends SelfBound<A>{}
    static class C extends SelfBound<C>{
        C setAndGet(C item){
            setElement(item);
            return getElement();
        }
    }

    static class F extends SelfBound{}
}
