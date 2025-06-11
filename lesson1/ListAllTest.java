package lesson1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixin on 2020/5/9.
 */
class ListAllTest {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("1");
        lists.add("1");
        lists.add("1");
        lists.set(3, "3");

        List<String> lists1 = new ArrayList<>();
        lists.add("2");
        lists.add("2");
        lists.add("2");
        lists.add("2");
        lists.set(3, "4");

        List<String> lists2 = new ArrayList<>();
        lists.add("3");
        lists.add("3");
        lists.add("3");
        lists.add("3");
        lists.set(3, "5");

        List<String> lists3 = new ArrayList<>();
        lists3.addAll(lists);
        lists3.addAll(lists1);
        lists3.addAll(lists2);
        System.out.println(lists3);
    }
}
