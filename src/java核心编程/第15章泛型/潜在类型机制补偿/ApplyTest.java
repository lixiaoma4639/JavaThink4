package java核心编程.第15章泛型.潜在类型机制补偿;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 日期 : 2020/12/12.
 * 创建 : xin.li
 * 描述 : 将一个方法应用于序列 , 就是
 */
class ApplyTest {

    public static void main1(String[] args) throws Exception {
        List<Shape> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(new Shape());
        }
//        Apply.apply(list1 , Shape.class.getMethod("rotate"));
        Apply.apply(list1, Shape.class.getMethod("resize", int.class), 5);
    }

    public static void main2(String[] args) throws Exception {
        List<Square> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(new Square());
        }
        Apply.apply(list1 , Square.class.getMethod("rotate"));
        Apply.apply(list1, Square.class.getMethod("resize", int.class), 5);
    }

    public static void main3(String[] args) throws Exception{
        Apply.apply(new FilledList<>(Shape.class , 10) , Shape.class.getMethod("rotate"));
        System.out.println("------");
        Apply.apply(new FilledList<>(Shape.class , 5) , Square.class.getMethod("rotate"));
        System.out.println("------");
        Apply.apply(new FilledList<>(Circle.class , 3) , Circle.class.getMethod("rotate"));
    }

    public static void main(String[] args) throws Exception{
        Queue<Object> queue = new LinkedList<>();
        queue.add(new Shape());
        queue.add(new Square());
//        queue.add(new Circle());
        Apply.apply(queue , Shape.class.getMethod("rotate"));
    }


    static class Apply {
        public static <T, S extends Iterable<? extends T>> void apply(S seq, Method method, Object... args) {
            try {
                for (T t : seq) {
                    method.invoke(t, args);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    static class FilledList<T> extends ArrayList<T> {
        public FilledList(Class<? extends T> type, int size) {
            try {
                for (int i = 0; i < size; i++) {
                    add(type.newInstance());
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    static class Shape {

        public void rotate() {
            System.out.println("Shape rotate...");
        }
        public void resize(int size) {
            System.out.println("Shape 的 size 是 " + size);
        }

    }

    static class Square extends Shape {}
    static class Circle {
        public void rotate() {
            System.out.println("Circle rotate...");
        }
    }
}
