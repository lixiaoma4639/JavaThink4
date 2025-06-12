package java核心编程.第16章数组;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Generated;

/**
 * 日期 : 2020/12/13.
 * 创建 : xin.li
 * 描述 :
 */
class ArraysUtils {
    public static void main2(String[] args) {
        int[] i = new int[7];
        int[] j = new int[7];
        Arrays.fill(i , 50);
        Arrays.fill(j , 50);

        System.out.println(Arrays.equals(i , j));
    }

    public static void main1(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i , 47);
        Arrays.fill(j , 50);

        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(j));
        //数组复制
        System.arraycopy(i , 0 , j, 2 , i.length - 1);
        System.out.println(Arrays.toString(j));

        int[] k = new int[5];
        Arrays.fill(k , 53);
        System.arraycopy(i , 0 , k, 0 , k.length);
        System.out.println(Arrays.toString(k));
    }

    public static void main3(String[] args) {
        ComparatorType[] types = {
                new ComparatorType(14),
                new ComparatorType(24),
                new ComparatorType(16),
                new ComparatorType(34),
        };
//        Arrays.sort(types);
//        System.out.println(Arrays.toString(types));

//        Arrays.sort(types , Collections.reverseOrder());
//        System.out.println(Arrays.toString(types));

        Arrays.sort(types , new MyComparator());
        System.out.println(Arrays.toString(types));
    }


    static class ComparatorType implements Comparable<ComparatorType>{

        private int age;

        public int getAge() {
            return age;
        }

        public ComparatorType(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(ComparatorType o) {
            return this.age - o.getAge();
        }

        @Override
        public String toString() {
            return age+"岁";
        }
    }

    static class MyComparator implements Comparator<ComparatorType>{
        @Override
        public int compare(ComparatorType o1, ComparatorType o2) {
            return -(o1.getAge() - o2.getAge()) ;
        }
    }


    public static void main5(String[] args) {
        String[] letters = {"B" , "A" , "H" , "C" ,"E" ,"D" , "WA" ,"F" ,"G" , "b" , "a" };
        Arrays.sort(letters );
        System.out.println(Arrays.toString(letters));

        Arrays.sort(letters , Collections.reverseOrder() );
        System.out.println(Arrays.toString(letters));

        Arrays.sort(letters , String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(letters));
    }

    public static void main6(String[] args) {
        int[] num = {199 , 23 ,434, 545, 234, 243, 532, 43, 889};
        Arrays.sort(num );
        System.out.println(Arrays.toString(num));
        int i = Arrays.binarySearch(num, 400);
        System.out.println(i);
        System.out.println(Arrays.binarySearch(num, 43));
    }

    public static void main(String[] args) {
        List list = null;
        list.isEmpty();
    }


}
