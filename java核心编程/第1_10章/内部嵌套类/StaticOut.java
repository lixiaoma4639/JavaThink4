package java核心编程.第1_10章.内部嵌套类;

/**
 * 日期 : 2020/9/13.
 * 创建 : xin.li
 * 描述 :
 */
class StaticOut {

    public StaticOut() {
        System.out.println("3");
    }

    class BaseInner{
        BaseInner() {
            System.out.println("2");
        }
    }

    static class A{
        static String aaa;
        static void f(){}

        static class B{
        }
    }
}
