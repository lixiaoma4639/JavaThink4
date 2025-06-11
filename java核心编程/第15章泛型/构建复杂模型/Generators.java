package java核心编程.第15章泛型.构建复杂模型;

import java.util.ArrayList;
import java.util.Collection;

import java核心编程.第15章泛型.泛型接口.Coffee;
import java核心编程.第15章泛型.泛型接口.CoffeeGenerator;
import java核心编程.第15章泛型.泛型接口.Fibonacci;
import java核心编程.第15章泛型.泛型接口.Generator;

/**
 * 日期 : 2020/12/4.
 * 创建 : xin.li
 * 描述 :
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(generator.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> fills = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 10);
        for (Coffee coffee :  fills) {
            System.out.print(coffee + " ");
        }

        System.out.println();

        Collection<Integer> fibs = fill(new ArrayList<Integer>(), new Fibonacci(), 20);
        for (Integer f :  fibs) {
            System.out.print(f + " ");
        }

    }
}
