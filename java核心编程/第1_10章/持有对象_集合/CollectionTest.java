package java核心编程.第1_10章.持有对象_集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

/**
 * 日期 : 2020/10/11.
 * 创建 : xin.li
 * 描述 :
 */
class CollectionTest {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("A");
        l.add("B");
        l.add("C");




        ListIterator<String> it = l.listIterator();
        /*while (it.hasNext()){
            System.out.println("next = " + it.next() + " , nextIndex= " + it.nextIndex() +
                    " , previousIndex= " + it.previousIndex());
        }

        while (it.hasPrevious()){
            System.out.println("pre = " + it.previous());
        }*/
//
//        it = l.listIterator(0);
//        while (it.hasNext()){
//            String next = it.next();
//            System.out.println("next = " + next);
//            it.set("D");
//        }
//        System.out.println(l);


//        display(l.iterator());

//        Set<Integer> set = new TreeSet<>();
//        Random random = new Random(47);
//        for (int i = 0; i < 100; i++) {
//            set.add(random.nextInt(100));
//        }
//        System.out.println(set);





//        Queue<String> q;
//        Stack<String> stack;
//
        Map<Integer , Integer> map = new HashMap<>();
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            Integer key = entry.getKey();
//            Integer value = entry.getValue();
//        }


        Random random = new Random(47);
        for (int i = 0; i < 1000; i++) {
            int r = random.nextInt(20);
            Integer integer = map.get(r);
            map.put(r , integer == null ? 1 : integer + 1);
        }
        System.out.println(map);



//        List<Base> bases = Arrays.asList(new A(), new B(), new C());
//
//        List<Base> bases3 = new ArrayList<>();
//        Collections.addAll(bases3 , new AA1(), new AA2());
//
//        List<Base> bases2 = Arrays.asList(new AA1(), new AA2());

        ReverseArrayList<Integer> reverseArrayList = new ReverseArrayList<>(Arrays.asList(1 , 2, 3 ,4 ,5));

        for (int aa: reverseArrayList) {
            System.out.print(aa + " ");
        }
        System.out.println("\n");
        for (int aa: reverseArrayList.reverse()) {
            System.out.print(aa + " ");
        }

    }

    public static void display(Iterator<String> it){
        while (it.hasNext()){
            String next = it.next();
            it.remove();
            System.out.println("next = " + next);
        }
    }

    static class Base{}
    static class A extends Base{}
    static class AA1 extends A{};
    static class AA2 extends A{}
    static class B extends Base{}
    static class C extends Base{}


    static class ReverseArrayList<E> extends ArrayList<E>{
        public ReverseArrayList(Collection<? extends E> c) {
            super(c);
        }

        /**
         * 反转遍历
         */
        public Iterable<E> reverse(){

            return new Iterable<E>() {
                @Override
                public Iterator<E> iterator() {
                    return new Iterator<E>() {
                        int reverseIndex = size() - 1;

                        @Override
                        public boolean hasNext() {
                            return reverseIndex > -1;
                        }

                        @Override
                        public E next() {
                            return get(reverseIndex--);
                        }
                    };
                }
            };
        }
    }
}
