package lesson1;

import java.util.*;

/**
 * Created by lixin on 2020/4/21.
 */
class SetTest {
    public static void main(String[] args) {
        Set<String>  stringHashSet = new LinkedHashSet<>();
        stringHashSet.add("1");
        stringHashSet.add("2");
        stringHashSet.add("3");
        stringHashSet.add("4");
//        System.out.println(stringHashSet.toString());


        List<String> lists = new LinkedList<>();
        lists.add("1");
        lists.add("1");
        lists.add("1");
        lists.add("1");
        lists.set(3 , "3");
//        System.out.println(lists.toString());


        List<String> VectorLists = new Vector<>();
        VectorLists.add("1");
        VectorLists.add("1");
        VectorLists.add("1");
        VectorLists.add("1");
        VectorLists.add("1");
        VectorLists.set(3 , "4");
//        System.out.println(VectorLists.toString());


        int a = 1;
        if (a == 1){
            a = a + 4;
            if (a != 2){
            }
            a = a + 4;
        }
        System.out.println(a);
    }
}
