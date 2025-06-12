package java核心编程.第15章泛型.潜在类型机制补偿;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java核心编程.第15章泛型.泛型接口.Coffee;
import java核心编程.第15章泛型.泛型接口.Generator;

/**
 * 日期 : 2020/12/12.
 * 创建 : xin.li
 * 描述 :
 */
class Fill2Test {

    public static <T> void fill(FillAdapter<T> adapter , Class<? extends T> type , int size){
        try {
            for (int i = 0; i < size; i++) {
                adapter.add(type.newInstance());
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static <T> void fill(FillAdapter<T> adapter , Generator<T> generator, int size){
        for (int i = 0; i < size; i++) {
            adapter.add(generator.next());
        }
    }

    static class AddCollectionAdapter<T> implements FillAdapter<T>{

        private Collection<T> collection;

        public AddCollectionAdapter(Collection<T> collection) {
            this.collection = collection;
        }

        @Override
        public void add(T t) {
            collection.add(t);
        }

        public static <E> FillAdapter<E> collectionAdapter(Collection<E> collection){
            return new AddCollectionAdapter<>(collection);
        }
    }


    static class SimpleQueueAdapter<T> implements FillAdapter<T>{
        @Override
        public void add(T t) {

        }
    }

    public static void main(String[] args) {
        List<Coffee> list = new ArrayList<>();
        Fill2Test.fill(AddCollectionAdapter.collectionAdapter(list) , Coffee.class , 5);
        System.out.println(list);

        SimpleQueueAdapter<Coffee> simpleQueueAdapter = new SimpleQueueAdapter<>();
        Fill2Test.fill(simpleQueueAdapter , Coffee.class , 5);

    }


}
