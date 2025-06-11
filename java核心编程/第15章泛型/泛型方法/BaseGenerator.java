package java核心编程.第15章泛型.泛型方法;

import java核心编程.第15章泛型.泛型接口.Generator;

/**
 * 日期 : 2020/12/3.
 * 创建 : xin.li
 * 描述 : 快速创建对象
 */
class BaseGenerator<T> implements Generator<T> {
    private Class<T> type;

    BaseGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> generator(Class<T> type){
        return new BaseGenerator<>(type);
    }

    static class CountObject{
        private static long count = 0;
        private final long id = count++;
        public long id(){ return id ; }


        public static void main(String[] args) {
            Generator<CountObject> generator = BaseGenerator.generator(CountObject.class);
            for (int i = 0; i < 5; i++) {
                //每调用一次generator.next(), 就会生产一个CountObject对象
                System.out.println(generator.next());
            }
        }

        @Override
        public String toString() {
            return "CountObject id = " + id;
        }
    }


}
