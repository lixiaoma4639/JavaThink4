package java核心编程.第12章异常.捕获所有的异常;

/**
 * 日期 : 2020/11/17.
 * 创建 : xin.li
 * 描述 :
 */
class 异常链 {
    static class MyException extends Exception{}
    static void a() throws MyException{
        System.out.println("a()被打印 了....");
        throw new MyException();
    }
    static void b() throws NullPointerException{
        try {
            a();
        } catch (MyException e) {
            NullPointerException nullPointerException = new NullPointerException();
            nullPointerException.initCause(e);
            throw nullPointerException;
        }
        System.out.println("b()被打印 了....");
    }

    public static void main(String[] args) {
        try {
            b();
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }

    }


}
