package java核心编程.第15章泛型.简单泛型;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
class Holder3<T> {
    private T t;

    public Holder3(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    //error
//    private static T getH(){
//        return t;
//    }

    public static void main(String[] args) {
        Holder3<String> holder3 = new Holder3<>("hello...");
        System.out.println(holder3.getT());
        holder3.setT("world");
        System.out.println(holder3.getT());

        Holder3<Number> numberHolder3 = new Holder3<>(1);
        System.out.println(numberHolder3.getT());
        numberHolder3.setT(1.2);
        System.out.println(numberHolder3.getT());
    }
}
