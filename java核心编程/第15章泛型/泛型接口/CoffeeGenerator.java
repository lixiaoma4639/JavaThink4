package java核心编程.第15章泛型.泛型接口;

import java.util.Iterator;
import java.util.Random;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
public class CoffeeGenerator implements Generator<Coffee> , Iterable<Coffee> {
    private Class[] types = {
            Coffee.ACoffee.class,
            Coffee.BCoffee.class,
            Coffee.CCoffee.class,
            Coffee.DCoffee.class,
            Coffee.ECoffee.class
    };

    private static Random random  = new Random(47);

    private int size;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    public CoffeeGenerator() {
    }

    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(coffeeGenerator.next());
        }

        System.out.println("-------------------");

        for (Coffee coffee: new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[random.nextInt(types.length)].newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee>{
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
