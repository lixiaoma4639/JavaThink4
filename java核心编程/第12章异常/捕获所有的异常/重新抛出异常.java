package java核心编程.第12章异常.捕获所有的异常;

/**
 * 日期 : 2020/11/16.
 * 创建 : xin.li
 * 描述 :
 */
class 重新抛出异常 {

    static void f() throws Exception{
        System.out.println("异常产生...");
        throw new Exception("throw form f()...");
    }

    static void g() throws Exception{
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw e;
        }
    }

    static void h() throws Exception{
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        System.out.println();

        try {
            h();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
