package java核心编程.第12章异常.java标准异常;

/**
 * 日期 : 2020/11/17.
 * 创建 : xin.li
 * 描述 :
 */
class RuntimeExceptionExplain {
    static void f() {
        throw new NullPointerException();
    }

    static void g() {
        f();
//        throw new ArrayIndexOutOfBoundsException();
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println("异常被抓住了...");
    }
}
