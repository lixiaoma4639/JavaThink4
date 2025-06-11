package java核心编程.第14章类型信息.Class对象;

import java.util.Random;

/**
 * 日期 : 2020/11/30.
 * 创建 : xin.li
 * 描述 :
 */
class 类字面量 {
    public static void main(String[] args) throws ClassNotFoundException {

//        Class<Integer> integerClass = int.class;
//        Class<Integer> type = Integer.TYPE;

        //惰性, 不会初始化class
        Class initAble = InitAble.class;

        System.out.println(InitAble.staticFinal);
        System.out.println(InitAble.staticFinal2);
        System.out.println(InitAble.staticFinal2);


        System.out.println(InitAble1.staticNoFinal);

        Class<?> aClass = Class.forName("java核心编程.第14章类型信息.Class对象.InitAble2");
        System.out.println("InitAble2 class已经被加载了...");
        System.out.println(InitAble2.staticNoFinal);
    }

    public static Random random = new Random(47);

    static class InitAble{
        public static final String staticFinal = "47";
        static final int staticFinal2 = 类字面量.random.nextInt(1000);
        static {
            System.out.println("InitAble类 被加载了...");
        }
    }

    static class InitAble1{
        static  int staticNoFinal = 147;
        static {
            System.out.println("InitAble1类 被加载了...");
        }
    }
}
