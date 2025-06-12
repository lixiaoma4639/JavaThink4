package java核心编程.第15章泛型.泛型接口;

import java.util.Iterator;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 :
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.print(fibonacci.next() + " ");
        }
    }

    private int fib(int count){
        if (count < 2) return count;
        return fib(count - 2) + fib(count - 1);
    }

    @Override
    public Integer next() {
        return fib(count++);
    }



    static class FibonacciIterator extends Fibonacci implements Iterable<Integer>{
        private int n;

        public FibonacciIterator(int n) {
            this.n = n;
        }

        public static void main(String[] args) {
            for (int item : new FibonacciIterator(18)) {
                System.out.print(item + " ");
            }
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {

                @Override
                public boolean hasNext() {
                    return n >0;
                }

                @Override
                public Integer next() {
                    n--;
                    return FibonacciIterator.this.next();
                }
            };
        }
    }
}
