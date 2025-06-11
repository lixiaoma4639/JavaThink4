package java核心编程.第12章异常.自定义异常;

/**
 * 日期 : 2020/11/16.
 * 创建 : xin.li
 * 描述 :
 */
class FullConstruct {

    static void f() throws MyException{
        System.out.println("f触发了异常");
        throw new MyException();
    }

    static void g() throws MyException{
        System.out.println("g触发了异常");
        throw new MyException("origin in g()...");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
        }

        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }

    }


    private static class MyException extends Exception{
        public MyException() {
        }

        public MyException(String message) {
            super(message);
        }
    }
}
