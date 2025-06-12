package java核心编程.static_learn;


import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 日期 : 2020/8/22.
 * 创建 : xin.li
 * 描述 :
 */
class StaticTest {
    public static void f(){
        System.out.println("hello f()....");
    }

    public static void main(String[] args) {
        Object aaa = null;
        String bbb = (String) aaa;
        System.out.println(bbb);
    }

    public static void main1(String[] args) {
        Table table = new Table();
        StaticTest test = new StaticTest();
        test.f();


        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault.getCountry());
        System.out.println(aDefault.getLanguage());
        System.out.println(aDefault.toString());
    }

    public static void main2(String[] args) {
        Map<String , Integer> map = new HashMap<>();
        map.put("fff" , 1);
        map.put(null , 2);
        map.put("" , 3);
        boolean b = map.containsKey(null);
        System.out.println(b);
        System.out.println(map.containsKey(""));
        System.out.println(map.get(null));
    }

    public static void main3(String[] args) {
        try {
            f2();
            try {
                f3();
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println("A");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("B");
        }
    }

    private static void f2() throws IOException{
    }

    private static void f3() throws Exception {
    }


    public static void main6(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.DATE , 5);
        System.out.println(instance.getTime());
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));
        System.out.println(instance.getFirstDayOfWeek());
    }













}
