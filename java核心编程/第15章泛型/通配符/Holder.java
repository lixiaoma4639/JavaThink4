package java核心编程.第15章泛型.通配符;

/**
 * 日期 : 2020/12/7.
 * 创建 : xin.li
 * 描述 :
 */
class Holder<T> {
    private T t;

    public Holder() {
    }

    public Holder(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
