package java核心编程.第15章泛型.协变逆变;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期 : 2021/6/24.
 * 创建 : xin.li
 * 描述 :
 * 定义
 * 逆变与协变用来描述类型转换（type transformation）后的继承关系，其定义：如果A、B表示类型，f(⋅)表示类型转换，≤表示继承关系（比如，A≤B表示A是由B派生出来的子类）
 * f(⋅)是逆变（contravariant）的，当A≤B时有f(B)≤f(A)成立；
 * f(⋅)是协变（covariant）的，当A≤B时有f(A)≤f(B)成立；
 * f(⋅)是不变（invariant）的，当A≤B时上述两个式子均不成立，即f(A)与f(B)相互之间没有继承关系。
 *
 * 数组是协变的
 * Java中数组是协变的，可以向子类型的数组赋予基类型的数组引用
 *
 * 协变
 * Java泛型是不变的，可有时需要实现协变，在两个类型之间建立某种类型的向上转型关系，怎么办呢？这时，通配符派上了用场。
 * 现在flist的类型是<? extends Fruit>，extends指出了泛型的上界为Fruit，<? extends T>称为子类通配符
 *
 * 逆变
 * 重用了关键字super指出泛型的下界为Apple，<？ super T>称为超类通配符，?代表一个具体类型，而这个类型是Apple的超类。
 * 这样编译器就知道向其中添加Apple或Apple的子类型（例如FuShiApple）是安全的了。
 * 但是，既然Apple是下界，那么可以知道向这样的List中添加Fruit是不安全的。
 *
 */
class 理解协变逆变 {

    public static void main(String[] args) {
        /**
         * 无论是Fruit数组还是List<? extends Fruit>都是协变, 协变会有多个子类, 由于协变泛型有多个子类, 引用可以指向任何一个子类, 因此不能向其中添加元素
         */
        /*Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();//运行期出错
        fruits[1] = new Orange();//运行期出错*/


        //协变
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        readFrom(apples);
        List<FuShiApple> fuShiApples = new ArrayList<>();
        fuShiApples.add(new FuShiApple());
        fuShiApples.add(new FuShiApple());
        readFrom(fuShiApples);
        //readFrom(new ArrayList<Fruit>());//编译期出错


        //逆变
        List<Fruit> fruits = new ArrayList<>();
        writeTo(fruits);
        System.out.println(fruits.get(0));
        writeTo(new ArrayList<Apple>());
        writeTo(new ArrayList<Object>());
        //writeTo(new ArrayList<FuShiApple>());//编译期出错

    }

    /**
     * 协变中, 不能添加任何元素
     * 协变会有多个子类, 由于协变泛型有多个子类, 不知道将来引用会指向哪一个子类, 因此不能向其中添加元素
     * 协变是限制数据来源的（生产者）, 产出数据,可以使用数据
     */
    static void readFrom(List<? extends Apple> apples) {
        //apples.add(new Fruit());//编译期出错
        //apples.add(new Apple());//编译期出错
        //apples.add(new Orange());//编译期出错
        for (int i = 0; i < apples.size(); i++) {
            Apple apple = apples.get(i);
            System.out.println(apple);
        }
    }

    /**
     * 逆变super是限制数据流入的（消费者）, 由于不知道逆变中添加的元素是哪一个父类, 因此不能在逆变中去get获取元素
     */
    static void writeTo(List<? super Apple> apples){
        apples.add(new Apple());
        apples.add(new FuShiApple());
        //apples.add(new Fruit());//编译期出错
        for (int i = 0; i < apples.size(); i++) {
            //Fruit apple = apples.get(i);//编译期出错
        }
    }


    static class Fruit {
        @Override
        public String toString() {
            return "水果";
        }
    }
    static class Apple extends Fruit {
        @Override
        public String toString() {
            return "苹果";
        }
    }
    static class FuShiApple extends Apple {
        @Override
        public String toString() {
            return "富士苹果";
        }
    }
    static class Orange extends Fruit {}
}
